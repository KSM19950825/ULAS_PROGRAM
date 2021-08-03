package com.las.khj.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;



public class AutoMail {
	@Autowired
	private JavaMailSender mailSender;	//autowired자바단에서 안써지는 듯		
	
//	반납 예정일 메일링
	public void SendReturnInfoEmail() {
		// 메일의 내용을 전송하기 위한 객체 MimeMessage
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
		
	}
//	연체 시 메일링
	public void SendPenaltyEmail() {
		// 메일의 내용을 전송하기 위한 객체 MimeMessage
		MimeMessage message = mailSender.createMimeMessage();
	}
//	예약자 대출일 메일링
	public void SendReserveEmail() {
		// 메일의 내용을 전송하기 위한 객체 MimeMessage
		MimeMessage message = mailSender.createMimeMessage();
	}
		
	
	
	

}
