package com.codinghub.service;

import com.codinghub.command.UserVO;

public interface UserService {
	
	/**
	 * 
	 * @param userVo
	 * @return void
	 * 
	 * 회원가입 메서드
	 */
	public void regist(UserVO userVo);
	
	/**
	 * 
	 * @param userVo
	 * @return UserVO
	 * 
	 * 로그인 메서드 VO에 담아 로그인 처리
	 */
	public UserVO login(UserVO userVo);
	
}
