package com.las.khj.model.service;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.las.khj.dto.Rent_Dto;
import com.las.khj.dto.Reservation_Dto;
import com.las.khj.model.dao.IRentalDao;

@Service
public class RentalServiceImpl implements IRentalService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private IRentalDao rDao;
	
	@Autowired
	private JavaMailSender mailSender;

	//	대출	
	@Override
	public int rentBook(Map<String, Object> map) {
		log.info("RentalServiceImpl 대출 ");
		return rDao.rentBook(map);
	}
	//	반납
	@Override
	public int returnBook(Map<String, Object> map) {
		log.info("RentalServiceImpl 반납 ");
		return rDao.returnBook(map);
	}
	//	예약 신청 tx
	@Transactional
	@Override 
	public boolean reserveBook(Map<String, Object> map) {
		log.info("RentalServiceImpl 예약 ");
		int isc1 = rDao.reserveBookInsert(map);
		int isc2 = rDao.reserveBookUpdate(map);
	    return (isc1>0&&isc2>0)?true:false;
	}
	//로그 수정{}값체크
	//	예약 취소 tx
	@Transactional
	@Override
	public boolean cancleReserve(Integer seq) {
		log.info("RentalServiceImpl 예약취소 ");
		int isc1 = rDao.cancleReserveDelete(seq);
		int isc2 = rDao.cancleReserveUpdate(seq);
	    return (isc1>0&&isc2>0)?true:false;
	}
	//	나의 예약 현황
	@Override
	public List<Reservation_Dto> myReservation(String email) {
		log.info("RentalServiceImpl 예약현황 ");
		return rDao.myReservation(email);
	}
	//	나의 대출 현황
	@Override
	public List<Rent_Dto> myRent(String email) {
		log.info("myRent 대출현황 ");
		return rDao.myRent(email);
	}	
	//	패널티
	@Override
	public int penaltyUpdate(String email) {
		log.info("RentalServiceImpl 페널티업데이트 ");
		return rDao.penaltyUpdate(email);
	}
	//	반납 예정일 메일링
//	@Override
//	public List<Rent_Dto> returnInfoEmail() {
//		log.info("RentalServiceImpl 반납일 하루 전 안내메일링 ");
//		return rDao.returnInfoEmail();
//	}
	
	@Override
	public void returnInfoEmail() {
		MimeMessage message = mailSender.createMimeMessage();
		List<String> mails = rDao.returnInfoEmail(); 
		for(String usermail:mails){
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				
				messageHelper.setFrom("dlrjtjd0615@gmail.com"); // 보내는 사람의 이메일
				messageHelper.setTo(usermail); // 받을 사람 이메일
				messageHelper.setSubject("[마을도서관] 안내 메일 드립니다."); // 메일의 제목
				messageHelper.setText("대출중인 도서의 반납일이 하루 남았습니다." , true);
				mailSender.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			log.info("RentalServiceImpl 반납일 하루 전 안내메일링 발송확인: "+ usermail);
		
		}

	}
	
	
	//	연체 시 메일링
	@Override
	public void penaltyEmail() {
		MimeMessage message = mailSender.createMimeMessage();
		List<String> mails = rDao.returnInfoEmail(); 
		for(String usermail:mails){
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				
				messageHelper.setFrom("dlrjtjd0615@gmail.com"); // 보내는 사람의 이메일
				messageHelper.setTo(usermail); // 받을 사람 이메일
				messageHelper.setSubject("[마을도서관] 안내 메일 드립니다."); // 메일의 제목
				messageHelper.setText("연체중인 도서가 있습니다. 빠른 시일내에 반납부탁드립니다." , true);
				mailSender.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			log.info("RentalServiceImpl 연체메일 발송완료: "+ usermail);
		
		}
		
	}
	//	예약자 대출일 메일링
	@Override
	public void reserveEmail() {
		MimeMessage message = mailSender.createMimeMessage();
		List<String> mails = rDao.returnInfoEmail(); 
		for(String usermail:mails){
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				
				messageHelper.setFrom("dlrjtjd0615@gmail.com"); // 보내는 사람의 이메일
				messageHelper.setTo(usermail); // 받을 사람 이메일
				messageHelper.setSubject("[마을도서관] 안내 메일 드립니다."); // 메일의 제목
				messageHelper.setText("예약중인 도서가 반납되어 대출 가능합니다. 3일 이내로 대출해주세요." , true);
				mailSender.send(message);
				
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			log.info("RentalServiceImpl 예약자 대출 가능 메일링 발송완료: "+ usermail);
		
		}
		
		
	}

}
