package com.codinghub.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codinghub.command.BoardVO;
import com.codinghub.service.BoardMapper;
import com.codinghub.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int registContent(BoardVO boardVo) {
		return boardMapper.registContent(boardVo);
	}
	
	@Override
	public ArrayList<BoardVO> getList(BoardVO boardVo) {
		return boardMapper.getList(boardVo);
	}
	
	@Override
	public BoardVO getContent(int bno) {
		return boardMapper.getContent(bno);
	}
	
	@Override
	public ArrayList<String> linkContent(BoardVO boardVo) {
		return boardMapper.linkContent(boardVo);
	}
	
}
