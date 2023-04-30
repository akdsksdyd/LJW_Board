package com.codinghub.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {

	private String userName;
	private String id;
	private String pw;
	
}
//CREATE TABLE USERS (
//		uno	int	NOT NULL,
//		userName	varchar(10)	NULL,
//		id	varchar(20)	NULL,
//		pw	varchar(20)	NULL
//);
