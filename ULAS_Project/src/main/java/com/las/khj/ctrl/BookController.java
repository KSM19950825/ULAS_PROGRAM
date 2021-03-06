package com.las.khj.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.las.khj.dto.BookInfo_Dto;
import com.las.khj.dto.Member_Dto;
import com.las.khj.model.service.IBookService;

@Controller
public class BookController {

	@Autowired
	private IBookService bookService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/main.do" , method = RequestMethod.GET)
	public String main(HttpSession session) {
		log.info("BookController 메인페이지 이동");
		//임시세션처리
		Member_Dto sessionUser = new Member_Dto();
		sessionUser.setEmail("ksm@gmail.com");
		sessionUser.setAuth("U");
		sessionUser.setName("정승호");
		session.setAttribute("sessionUser", sessionUser);
		return "index";
	}
	
	@RequestMapping(value = "/searchBook.do" , method = RequestMethod.GET)
	public String searchBook() {
		log.info("BookController 도서검색 크롤링 이동");
		return "searchBook";
	}
	
	@RequestMapping(value = "/searchBookList.do" , method = RequestMethod.GET)
	public String searchBookList(String bookName, Model model) {
		List<BookInfo_Dto> bookDtoList =  new ArrayList<BookInfo_Dto>();
		log.info("BookController 크롤링으로 검색된 단어 : {}", bookName);
		System.out.println("검색단어 : "+bookName);
		String bookURL = "https://search.daum.net/search?nil_suggest=btn&w=book&DA=PGD&q="+bookName+"&sort=accuracy&page=1";
		try {
			Document book = Jsoup.connect(bookURL).get();
			 Elements elem = book.select("ul").select(".list_info").select(".f_link_bu");
			 int cnt=0;
			 for (Element e : elem) {
				BookInfo_Dto dto = new BookInfo_Dto();
				System.out.printf("%s / %s \n", e.text(), "https://search.daum.net/search"+e.attr("href"));
			
				dto.setTitle(e.text());
				dto.setContent(e.attr("href"));
				bookDtoList.add(dto);
				
				if(cnt++ ==2) {
					break;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		model.addAttribute("bookList",bookDtoList); // 키워드를 통해 크롤링된 도서의 리스트를 화면에 전달
		return "searchBookList";
	}
	
	@RequestMapping(value = "/searchBookDetail.do" , method = RequestMethod.POST)
	public String searchBookDetail(String url , Model model, HttpServletResponse response) {
		BookInfo_Dto bookDto = new BookInfo_Dto();
		log.info("BookController 크롤링된 리스트 중 선택한 도서정보 : {}", bookDto);
		String detailUrl = "https://search.daum.net/search"+url;
		try {
			Document detail = Jsoup.connect(detailUrl).get(); // 리스트에서 크롤링된 주소를 다시 크롤링
			Elements elements = detail.select(".tab_body").select("div"); // 가져올 정보의 공통 요소를 선택
			Element e = elements.get(0); // 선택한 공통 요소들을 요소로 나누고 첫 번째 요소를 가져옴
			
			// 선택한 요소를 Dto에 담아줌
			bookDto.setImg(e.select(".thumb").select("img").attr("src")); // 도서이미지
			bookDto.setTitle(e.select(".wrap_cont").select("strong.tit_book").text()); // 도서명
			bookDto.setAuthor(e.select(".wrap_cont").select("dd.cont").select("a").get(0).text()); // 저자
			bookDto.setPublcode(e.select(".wrap_cont").select("dd.cont").get(1).select("a").text());; // 출판사
			String date =e.select(".wrap_cont").select("dd.cont").get(1).text();
			bookDto.setPublishing(date.substring(date.indexOf("|")+1)); // 발행일
			bookDto.setContent(e.select(".info_section").select("p.desc").get(0).text()); // 책소개
			bookDto.setChapter(e.select(".info_section").select("p.desc").get(2).html().replaceAll("<br>", "\n")); // 목차
			
			log.info("이미지 : {}", bookDto.getImg());
			log.info("도서명 : {}", bookDto.getTitle());
			log.info("저자 : {}", bookDto.getAuthor());
			log.info("출판사 : {}", bookDto.getPublcode());
			log.info("발행일 : {}", bookDto.getPublishing());
			log.info("도서소개 : {}", bookDto.getContent());
			log.info("목차 : {}", bookDto.getChapter());
			
//			if(bookDto.getContent() == "" || bookDto.getChapter() == "") {
//				PrintWriter out = response.getWriter();
//				out.print("<script>chkBook();</script>");
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("searchDetail", bookDto); // Dto에 담긴 크롤링된 정보를 화면에 전달
		return "searchBookDetail";
	}
	
	@RequestMapping(value = "/findPublish.do" , method = RequestMethod.GET)
	public String findPublish() {
		log.info("BookController 출판사 조회로 이동");

		return "findPublish";
	}
	
	@RequestMapping(value = "/insertPublish.do" , method = RequestMethod.POST)
	@ResponseBody
	public String insertPublish(Model model, String publisher) {
		log.info("BookController 출판사 조회", publisher);
		BookInfo_Dto publ = bookService.searchPublish(publisher);
		model.addAttribute("publ", publ);
		return "";
	}
	

	
	@RequestMapping(value = "/bookList.do" , method = RequestMethod.GET)
	public String bookList(Model model) {
		List<BookInfo_Dto> listBook =  bookService.bookList();
		log.info("BookController 등록된 도서 전체리스트 조회", listBook);
		model.addAttribute("listBook", listBook);
		
		return "bookList";
	}
	
	@RequestMapping(value = "/insertBook.do" , method = RequestMethod.POST)
	public String insertBook(BookInfo_Dto insertDto, Model model) {
		log.info("BookController 등록되는 도서정보 : {}", insertDto);
		boolean isc = bookService.insertBooks(insertDto);
		System.out.println(isc);
		
		if(isc) {
			return "redirect:/bookList.do";
		}
		return null;
	}
	
	@RequestMapping(value = "/bookDetail.do" , method = RequestMethod.GET)
	public String bookDetailInfo(Model model, String bookcode) {
		log.info("BookController 전체리스트에서 선택된 bookcode : {}", bookcode);
		BookInfo_Dto detailBook = bookService.detailInfo(bookcode);
		log.info("BookController 등록된 도서의 상세정보 : {}", detailBook);
		model.addAttribute("detailBook", detailBook);

		return "bookDetail";
	}
	
	@RequestMapping(value = "/bookModify.do" , method = RequestMethod.GET)
	public String bookModify(Model model, String bookcode) {
		log.info("BookController 도서수정 페이지로 이동");
		BookInfo_Dto detailBook = bookService.detailInfo(bookcode);
		log.info("BookController 등록된 도서의 상세정보 : {}", detailBook);
		model.addAttribute("detailBook", detailBook);
		return "bookModify";
	}
	
	@RequestMapping(value = "/bookModifyForm.do" , method = RequestMethod.POST)
	public String bookModifyForm() { // 정보수정(도서상태, 위치) / 도서상태 위치 바꾸는거(이건 따로 url 만들어야 하나)
		log.info("BookController 도서정보 수정");
		
		return "bookDetail";
	}

	
}
