package com.las.khj.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.las.khj.dto.Member_Dto;
import com.las.khj.dto.Rent_Dto;
import com.las.khj.dto.Reservation_Dto;
import com.las.khj.mail.AutoMail;
import com.las.khj.model.service.IRentalService;



@Controller
public class RentalContoller {
	
	@Autowired
	private IRentalService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
//		대출					rentBook.do		
	@RequestMapping(value = "/rentBook.do", method = RequestMethod.POST)
	public String rentBook(@RequestParam int bookseq, HttpSession session, Model model) {
		Member_Dto dto = (Member_Dto) session.getAttribute("sessionUser");
		String email = (String)dto.getEmail();
		log.info("rentBook 대출");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("email",email);
		map.put("bookseq", bookseq);
		service.rentBook(map);
		return "rentBook";
	}
	
	
//		반납             		returnBook.do
	//int seq => 대출현황페이지 (input hidden)

	@RequestMapping(value = "/returnBook.do" ,method=RequestMethod.POST)
	public String returnBook(@RequestParam int seq, Model model,HttpSession session) {
		Member_Dto dto = (Member_Dto) session.getAttribute("sessionUser");
		String email = (String)dto.getEmail();
		log.info("returnBook 반납");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email",email);
		map.put("seq", seq);
		service.returnBook(map);
		return "returnBook";
		
	}
	
	
	
	//	예약 신청 tx           reserveBook.do  HttpSession session 로긴 기능 연결 후 수정
//	String email = session.getAttribute("email"); //실제화면session에서 email가져오기
//	int bookseq =  input hidden처리 된 bookseq 값 가져오기
	@RequestMapping(value = "/reserveBook.do", method = RequestMethod.POST)
	public String reserveBook(@RequestParam int bookseq ,Model model) {
		log.info("reserveBook 예약 신청");
		String email = "lgs@gmail.com";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("bookseq", bookseq);
		service.reserveBook(map);
		return "reserveBook";
	}
	// 예약 취소 tx           cancleReserve.do
	// input hidden 으로 reservation테이블의 seq를 가져와서 check해야함
	@RequestMapping(value = "cancleReserve.do", method = RequestMethod.POST)
	public String cancleReserve(@RequestParam int seq ,Model model) {
		log.info("cancleReserve 예약 취소");
		
		service.cancleReserve(seq);
		return "cancleReserve";
		
	}
	
	
	
	
	
	//	나의 예약 현황			myReservation.do
	@RequestMapping(value = "/myReservation.do" ,method=RequestMethod.GET)
	public String myReservation(Model model, HttpSession session) {
		Member_Dto dto = (Member_Dto) session.getAttribute("sessionUser");
		String email = (String)dto.getEmail();
		log.info("myReservation 나의 예약 현황");

		List<Reservation_Dto> lists = service.myReservation(email);
		System.out.println(lists);
		model.addAttribute("lists",lists);
		return "myReservation";
	}
	
	//나의 대출 현황 	myRent.do
	@RequestMapping(value = "/myRent.do", method = RequestMethod.GET)
	public String myRent(Model model, HttpSession session) {
		Member_Dto dto = (Member_Dto) session.getAttribute("sessionUser");
		String email = (String)dto.getEmail();
		
		List<Rent_Dto> lists = service.myRent(email);
		log.info("myReservation 나의 예약 현황");
		model.addAttribute("lists",lists);
		return "myRent";
		
	}
	
//	패널티                penaltyUpdate.do --cron으로 주기적으로 업데이트
	
	
	//	반납 예정일 메일링       returnInfoEmail.do
//	@RequestMapping(value = "/returnInfo.do" ,method=RequestMethod.GET)
//	public String returnInfoEmail(Model model) {
//		log.info("returnInfoEmail 반납 예정일 메일링");
//		List<Rent_Dto> lists = service.returnInfoEmail();
//		System.out.println(lists);
//		model.addAttribute("lists",lists);
//		return "returnInfoEmail";
//	}
	
	//	연체 시 메일링          penaltyEmail.do
//	@RequestMapping(value = "/penaltyEmail.do" ,method=RequestMethod.GET)
//	public String penaltyEmail(Model model) {
//		log.info("penaltyEmail 연체 시 메일링");
//		List<String> lists = service.penaltyEmail();
//		System.out.println(lists);
//		model.addAttribute("lists",lists);
//		return "penaltyEmail";
//	}
	//	예약자 대출일 메일링      reserveEmail.do
//	@RequestMapping(value = "/reserveEmail.do" ,method=RequestMethod.GET)
//	public String reserveEmail(Model model) {
//		log.info("RentalContoller 예약자 대출일 메일링");
//		List<String> lists = service.reserveEmail();
//		System.out.println(lists);
//		model.addAttribute("lists",lists);
//		return "reserveEmail";
//	}
	
	
	
	//메일 발송 테스트
	@RequestMapping(value = "/t.do", method = RequestMethod.GET)
	public void automail() {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom("dlrjtjd0615@gmail.com"); // 보내는 사람의 이메일
			messageHelper.setTo("shda410@gmail.com"); // 받을 사람 이메일
			messageHelper.setSubject("[마을도서관] 안내 메일 드립니다."); // 메일의 제목
			messageHelper.setText("대출중인 도서의 반납일이 하루 남았습니다. " , true);
			mailSender.send(message);
			} catch (MessagingException e) {
			e.printStackTrace();
			}
		
		System.out.println("메세지 발송확인");
		
	}
	
	
}
