package com.codinghub.service;

import org.apache.ibatis.annotations.Mapper;

import com.codinghub.command.UserVO;

@Mapper
public interface UserMapper {
	
	//회원가입
	public void regist(UserVO userVo);
	
	//로그인
	public UserVO login(UserVO userVo);
	
}
