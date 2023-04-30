package com.codinghub.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.command.UserVO;
import com.codinghub.service.UserMapper;
import com.codinghub.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void regist(UserVO userVo) {
		
		userMapper.regist(userVo);
	}
	
	@Override
	public UserVO login(UserVO userVo) {
		return userMapper.login(userVo);
	}
	
}
