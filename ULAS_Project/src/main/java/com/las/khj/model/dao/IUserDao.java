package com.las.khj.model.dao;

import java.util.Map;

import com.las.khj.dto.Member_Dto;

public interface IUserDao {
	/*
	 * 로그인 LAS-U-001
	 */
	public Member_Dto login(Map<String, Object> map);
	/*
	 * 회원가입 LAS-U-002
	 */
	public boolean regist(Member_Dto dto);
	/*
	 * 대출 회원 조회 LAS-U-003
	 */
	
	/*
	 * 내 정보 수정 LAS-U-005
	 */
	public boolean modifyInfo(Map<String, Object> map);
	/*
	 * 아이디 찾기 LAS-U-006
	 */
	public String findId(Map<String, Object> map);
	/*
	 * 비밀번호 찾기 LAS-U-007
	 */
	public String findPw(Map<String, Object> map);
	/*
	 * 인증번호 생성 LAS-U-007
	 */
	public boolean insertOtp(Map<String, Object> map);
	/*
	 * 인증번호 입력 LAS-U-007
	 */
	public String inquireOtp(Map<String, Object> map);
	/*
	 * 인증번호 삭제 LAS-U-007
	 */
	public boolean deleteOtp(String email);
	/*
	 * 비밀번호 변경 LAS-U-007
	 */
	public boolean modifyPw(Map<String, Object> map);
}
