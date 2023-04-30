package com.codinghub.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codinghub.command.BoardVO;
import com.codinghub.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(BoardVO boardVo,
					    Model model) {
		
		ArrayList<BoardVO> list = boardService.getList(boardVo);
		model.addAttribute("list", list);
		
		return "/board/board";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	
	@GetMapping("/registContent")
	public String registContent(BoardVO boardVo,
								HttpSession session,
							    RedirectAttributes ra) {
		
		boardVo.setId((String)session.getAttribute("userName"));
		
		int result = boardService.registContent(boardVo);
		String msg = "";
		
		if(result == 0) {
			msg = "글 등록 실패";
			ra.addFlashAttribute("msg", msg);
			
			return "redirect:/board/write";
		}
		
		msg = "글 등록 성공";
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:/board/board";
	}
	
	@GetMapping("/boardContent")
	public String boardContent(@RequestParam("bno") int bno,
							   Model model) {
		
		//게시글 내용 보여줄 vo
		BoardVO boardVo = boardService.getContent(bno);
		model.addAttribute("boardVo", boardVo);
		
		//연관게시글 계산 할 vo
		BoardVO vo = new BoardVO();
		ArrayList<String> list = boardService.linkContent(vo);
		
		//현재 내가 보고있는 배열
		String[] strArr = boardVo.getContent().split(" ");
		//현재 내가 보고있는 글 내용
		String content = boardVo.getContent();
		//첫번째 조건 검사 후 담을 리스트
		List<String> strArrLink = new ArrayList<>();
		//두번쨰 조건 검사 후 담을 리스트
		List<String> linkList = new ArrayList<>();
		//모든 content를 담을 배열
		String[] listArr = null;
		
		//연관게시글 첫번째 조건
		double firstCount = 0;
		//연관게시글 두번째 조건
		double secondCount = 0;
		
		for(int i = 0; i < strArr.length; i++) {
			
			for(int j = strArr.length-1; j > -1; j--) {
				
				if(strArr[i].equals(strArr[j]))firstCount++;
				
			}
			
			if(Math.round((firstCount / strArr.length) * 100) < 60) {
				
				strArrLink.add(strArr[i]);
				
			}
			firstCount = 0;
		}
		
		for(int a = 0 ; a < list.size(); a++) {
			
			listArr = list.get(a).split(" ");
			
			for(int i = 0; i < strArrLink.size(); i++) {
				
				for(int j = 0; j < listArr.length; j++) {
					if(strArrLink.get(i).equals(listArr[j])) secondCount++;
					
				}
				
				if(Math.round(secondCount / listArr.length * 100) <= 40 && secondCount > 1) {
					if(!list.get(a).equals(content)) {
						linkList.add(list.get(a));
					}
					
				}
				secondCount = 0;
				
			}
			
		}
		
		linkList = linkList.stream().distinct().collect(Collectors.toList());
		
		model.addAttribute("linkList", linkList);
		
		return "board/boardContent";
	}
	
}
