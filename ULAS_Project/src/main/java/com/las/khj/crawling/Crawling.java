package com.las.khj.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {

	public static void main(String[] args) throws IOException {
		
		String bookURL = "https://search.daum.net/search?nil_suggest=btn&w=book&DA=PGD&q=%EB%AA%A8%EB%8D%98+%EC%9B%B9%EC%9D%84&sort=accuracy&page=1";
		Document book = Jsoup.connect(bookURL).get();
		
//		String bookDetailURL = "https://search.daum.net/search?w=bookpage&bookId=945010&tab=introduction&DA=LB2&q=%EB%AA%A8%EB%8D%98%20%EC%9B%B9%EC%9D%84";
//		 Document bookDetail = Jsoup.connect(bookDetailURL).get();
		
		
		 
		 Elements elem = book.select("ul").select(".list_info").select(".f_link_bu");
		 int cnt=0;
		 for (Element e : elem) {
			System.out.println(e);
			if(cnt++ ==0) {
				break;
			}
			System.out.println("-----------------");
		}
		 
		 System.out.println(elem.text());
//			for (int i = 0; i <= 2; i++) {
//				String elem2 = elem.get(i).text();
//				System.out.println(elem2+"\n\n\n");
//			}
			
			
		// 도서이미지
//		Elements bookImg = book.select(".list_info mg_cont clear li");
//			for (int i = 0; i <= 5; i++) {
//				String img = bookImg.get(i).attr("src");
//				System.out.println(img);
//			}
//		
//		// 도서명
//		Elements bookTitle = bookDetail.select("strong.tit_book");
//			
//		// 도서저자
//		 Elements bookAuth = book.select("a.g_tit");
//			for (int i = 1; i <= 5; i++) {
//				String auth = bookAuth.get(i).text();
//				System.out.println(auth);
//			}
//		
//		// 출판사
//		Elements bookpubl = book.select("span.g_tit");
//			for (int i = 1; i <= 5; i++) {
//				String publ = bookpubl.get(i).text();
//				System.out.println(publ);
//			}
//		
//		// 발행일
//		Elements bookdate = book.select("div.f_date.info");
//			for (int i = 0; i <= 5; i++) {
//				String date = bookdate.get(i).text();
//				String result = date.substring(date.lastIndexOf("|")+2);
//				System.out.println(result);
//			}
//		
//		// 도서 상세정보
//		Elements bookDesc = bookDetail.select("div.info_section > p.desc");
//		System.out.println(bookDesc.text());
//		
//		// 목차
//		Elements bookContents = bookDetail.select("#tabContent > div:nth-child(1) > div:nth-child(5) > p");
////		Elements bookContents = bookDetail.select("div.info_section.fold_on > p.desc");
//		System.out.println(bookContents.text());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
