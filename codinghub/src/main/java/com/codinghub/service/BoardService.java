package com.codinghub.service;

import java.util.ArrayList;

import com.codinghub.command.BoardVO;

public interface BoardService {

	/**
	 * 
	 * @param boardVo
	 * @return int
	 * 
	 * 글작성 메서드
	 * insert성공시 반환 값으로 메시지 경고 출력
	 */
	public int registContent(BoardVO boardVo);
	
	/**
	 * 
	 * @param boardVo
	 * @return ArrayList<BoardVO>
	 * 
	 * 게시글 전체 목록 받아오는 메서드
	 */
	public ArrayList<BoardVO> getList(BoardVO boardVo);
	
	/**
	 * 
	 * @param bno
	 * @return BoardVO
	 * 
	 * bno를 받아 해당 bno의 content를 가져오는 메서드
	 */
	public BoardVO getContent(int bno);
	
	/**
	 * 
	 * @param boardVo
	 * @return String
	 * 
	 * 연관게시글 계산을 위한 메서드
	 * content의 목록을 받아온다
	 */
	public ArrayList<String> linkContent(BoardVO boardVo);
	
}
