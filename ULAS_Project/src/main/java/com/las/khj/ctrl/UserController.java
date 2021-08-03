package com.las.khj.ctrl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.las.khj.dto.Member_Dto;
import com.las.khj.model.service.IUserService;

@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	JavaMailSender mailSender;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("UserController 로그인화면이동");
		return "login";
	}
	
	@RequestMapping(value = "/loginCheckMap.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginCheckMap(@RequestParam Map<String, Object> map) {
		Map<String, String> temp = new HashMap<String, String>();
		System.out.println(map);
		logger.info("Member_Controller -> loginCheckMap {}", temp.get("email"));
		logger.info("Member_Controller -> loginCheckMap {}", temp.get("password"));
		Member_Dto uDto = userService.login(map);
		logger.info("Member_Controller -> loginCheckMap login : {}", uDto);
		if(uDto == null) {
			temp.put("isc", "실패");
		} else {
			temp.put("isc", "성공");
		}
		return temp;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session) {
		logger.info("Member_Controller -> loginCheckMap {}", map.get("email"));
		logger.info("Member_Controller -> loginCheckMap {}", map.get("password"));
		Member_Dto uDto = userService.login(map);
		session.setAttribute("uDto", uDto);
		return "main";
	}
	
	@RequestMapping(value = "/registForm.do", method = RequestMethod.GET)
	public String registForm() {
		logger.info("UserController 회원가입화면이동");
		return "registForm";
	}
	
	@RequestMapping(value = "/otpMake.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> otpMake(@RequestParam String email) {
		logger.info("UserController 이메일인증");
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("email", email);
		String checkId = "";
		checkId = userService.findPw(temp);
		
		if(checkId != null) {
			temp.put("isc", "실패");
			return temp;
		}
		Map<String, Object> tmp = new HashMap<String, Object>();
		tmp.put("email", email);
		
		Random ran = new Random();
		String num = "";
		String ranNum1 = Integer.toString(ran.nextInt(9)+1);
		num = ranNum1;
		for(int i = 0; i < 5; i++) {
			String ranNum2 = Integer.toString(ran.nextInt(10));
			num += ranNum2;
		}
		tmp.put("otp", num);
		System.out.println("//////////////////////////"+tmp);
		boolean isc = userService.insertOtp(tmp);
		
		if(isc) {
            String setfrom = "rkdtjdals20@gmail.com";
            String tomail = (String) tmp.get("email"); // 받는 사람 이메일
            String title = "회원가입 인증 이메일 입니다."; // 제목
            String content =
            
            System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
            
            System.getProperty("line.separator")+
                    
            "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다"
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
    
            " 인증번호는 " +(String) tmp.get("otp")+ " 입니다. "
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
            
            "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다.";
            
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                        true, "UTF-8");
 
                messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
                messageHelper.setTo(tomail); // 받는사람 이메일
                messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
                messageHelper.setText(content); // 메일 내용
                
                mailSender.send(message);
            } catch (Exception e) {
                System.out.println(e);
            }
			temp.put("isc", "성공");
		} else {
			temp.put("isc", "실패");
		}
		
		return temp;
	}
}
