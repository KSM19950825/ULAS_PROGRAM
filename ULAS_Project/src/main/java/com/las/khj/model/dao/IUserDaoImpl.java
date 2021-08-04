package com.las.khj.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.las.khj.dto.Member_Dto;

@Repository
public class IUserDaoImpl implements IUserDao {

private final String NS = "com.las.khj.model.dao.IUserDao.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member_Dto login(Map<String, Object> map) {
		return sqlSession.selectOne(NS + "login", map);
	}

	@Override
	public boolean regist(Member_Dto dto) {
		int n = sqlSession.insert(NS+"regist", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean modifyInfo(Map<String, Object> map) {
		int n = sqlSession.update(NS+"modifyInfo", map);
		return (n>0)?true:false;
	}

	@Override
	public String findId(Map<String, Object> map) {
		return sqlSession.selectOne(NS + "findId", map);
	}

	@Override
	public String findPw(Map<String, Object> map) {
		return sqlSession.selectOne(NS + "findPw", map);
	}

	@Override
	public boolean insertOtp(Map<String, Object> map) {
		int n = sqlSession.insert(NS+"insertOtp", map);
		return (n>0)?true:false;
	}

	@Override
	public String inquireOtp(Map<String, Object> map) {
		return sqlSession.selectOne(NS + "inquireOtp", map);
	}
	
	@Override
	public boolean deleteOtp(String email) {
		int n = sqlSession.delete(NS+"deleteOtp", email);
		return (n>0)?true:false;
	}

	@Override
	public boolean modifyPw(Map<String, Object> map) {
		int n = sqlSession.update(NS+"modifyPw", map);
		return (n>0)?true:false;
	}

}
