package com.codinghub.command;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {

	private int bno;
	private String title;
	private String content;
	private LocalDate date;
	private String id;
	
}

//CREATE TABLE BOARD (
//		bno	int	NOT NULL,
//		title	varchar(100)	NULL,
//		content	varchar(3000)	NULL,
//		date	date	NULL,
//		id varchar(20) NOT NULL
//);
