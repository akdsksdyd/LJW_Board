package com.codinghub.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.codinghub.command.BoardVO;

@Mapper
public interface BoardMapper {
	
	//글작성
	public int registContent(BoardVO boardVo);
	
	//글목록
	public ArrayList<BoardVO> getList(BoardVO boardVo);
	
	//상세내용
	public BoardVO getContent(int bno);
	
	//연관게시글 계산하기 위한 메서드
	public ArrayList<String> linkContent(BoardVO boardVo);

}
