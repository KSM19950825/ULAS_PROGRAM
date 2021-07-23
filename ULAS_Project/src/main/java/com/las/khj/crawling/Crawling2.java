package com.las.khj.crawling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.las.khj.dto.BookInfo_Dto;

public class Crawling2 {

	public static void bookInfo(ArrayList<BookInfo_Dto> info) throws IOException {
		
		String bookURL = "https://search.daum.net/search?nil_suggest=btn&w=book&DA=PGD&q=%EB%AA%A8%EB%8D%98+%EC%9B%B9%EC%9D%84&sort=accuracy&page=1";
		Document book = null;
		book = Jsoup.connect(bookURL).get();
		
		String bookDetailURL = "https://search.daum.net/search?w=bookpage&bookId=945010&tab=introduction&DA=LB2&q=%EB%AA%A8%EB%8D%98%20%EC%9B%B9%EC%9D%84";
		Document bookDetail = null;
		bookDetail = Jsoup.connect(bookDetailURL).get();
		
		
		
		// 도서이미지
		Elements bookimg = null;
		bookimg = book.select("img.thumb_img");
		for (Element element : bookimg) {
			System.out.println(element.attr("src"));
//			info.add(new BookInfo_Dto(bookimg));
		}
		
		// 도서명
		Elements bookauth = null;
		bookauth = book.select("a.g_tit");
			for (int i = 1; i <= 5; i++) {
				String auth = bookauth.get(i).text();
				System.out.println(auth);
			}
		
		// 출판사
		Elements bookpubl = book.select("span.g_tit");
			for (int i = 1; i <= 5; i++) {
				String publ = bookpubl.get(i).text();
				System.out.println(publ);
			}
		
		// 발행일
		Elements bookdate = book.select("div.f_date.info");
			for (Element element : bookdate) {
	//				element.select("img").select("a").select("span").remove();
	//				System.out.println(element.getElementsContainingText("#text"));
	//				System.out.println(element.removeAttr("img").removeAttr("a").removeAttr("span").text());
				String date = element.text();
				String result = date.substring(date.lastIndexOf("|")+2);
				System.out.println(result);
			}
		
		// 도서 상세정보
		Elements bookDesc = bookDetail.select("div.info_section > p.desc");
		System.out.println(bookDesc.text());
		
		// 목차
		Elements bookContents = bookDetail.select("#tabContent > div:nth-child(1) > div:nth-child(5) > p");
//		Elements bookContents = bookDetail.select("div.info_section.fold_on > p.desc");
		System.out.println(bookContents.text());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String bookURL = "https://book.naver.com/search/search.nhn?query=%EB%AA%A8%EB%8D%98+%EC%9B%B9%EC%9D%84+%EC%9C%84%ED%95%9C";
//		
//		// 도서이미지
//		Document book1 = Jsoup.connect(bookURL).get();
//		for (int j = 1; j <= 5; j++) {
//			Elements bookImg = book1.select("#searchBiblioList > li:nth-child("+j+") > div > div > a > img");
//			System.out.println(bookImg.attr("src"));
//		}
//		
//		// 도서명
//		Document book2 = Jsoup.connect(bookURL).get();
//		for (int j = 1; j <= 5; j++) {
//			Elements bookImg = book2.select("#searchBiblioList > li:nth-child("+j+") > div > div > a > img");
//			System.out.println(bookImg.attr("alt"));
//		}
//		
//		// 도서저자
//		Document book3 = Jsoup.connect(bookURL).get();
//		Elements bookAuth = book2.select("dd.txt_block");
//		for (int j = 1; j <= 5; j++) {
//			String auth = bookAuth.get(j).text();
//			System.out.println(auth);
//		}
	}
}
