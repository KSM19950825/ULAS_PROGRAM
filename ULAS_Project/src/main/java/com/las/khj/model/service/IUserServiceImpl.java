package com.las.khj.model.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.las.khj.dto.Member_Dto;
import com.las.khj.model.dao.IUserDao;

@Service
public class IUserServiceImpl implements IUserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserDao iDao;
	
	@Override
	public Member_Dto login(Map<String, Object> map) {
		logger.info("IUserServiceImpl 로그인 : {}", map);
		return iDao.login(map);
	}

	@Override
	public boolean regist(Member_Dto dto) {
		logger.info("IUserServiceImpl 회원가입 : {}", dto);
		return iDao.regist(dto);
	}

	@Override
	public boolean modifyInfo(Map<String, Object> map) {
		logger.info("IUserServiceImpl 회원수정 : {}", map);
		return iDao.modifyInfo(map);
	}

	@Override
	public String findId(Map<String, Object> map) {
		logger.info("IUserServiceImpl 아이디찾기 : {}", map);
		return iDao.findId(map);
	}

	@Override
	public String findPw(Map<String, Object> map) {
		logger.info("IUserServiceImpl 비밀번호찾기 : {}", map);
		return iDao.findPw(map);
	}

	@Override
	public boolean insertOtp(Map<String, Object> map) {
		logger.info("IUserServiceImpl 일회용번호생성 : {}", map);
		return iDao.insertOtp(map);
	}

	@Override
	public String inquireOtp(Map<String, Object> map) {
		logger.info("IUserServiceImpl 일회용번호대조 : {}", map);
		return iDao.inquireOtp(map);
	}

	@Override
	public boolean modifyPw(Map<String, Object> map) {
		logger.info("IUserServiceImpl 비밀번호변경 : {}", map);
		return iDao.modifyPw(map);
	}

}
