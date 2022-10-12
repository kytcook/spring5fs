 package com.meaningFarm.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meaningFarm.board.vo.BoardVO;
import com.meaningFarm.taek.Service;
import com.webjjang.util.PageObject;

// 자동생성 - @Controller, @Service, @Repository, @Compnent, @RestController, @Advice
// 단, servlet-context.xml에서 component-scan 태그에서 base-package 안에 작성되어 있어야 한다.
@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	private Service boardListService;
	
	// DI 적용 - Autowired, @Inject
	@Autowired
	public void setBoardListService(Service boardListService) {// 서비스로 보낸다.
		this.boardListService = boardListService;
		
	}

	// 게시판 리스트
	@GetMapping("/list.do")
	public String list(PageObject pageObject, Model model) throws Exception {
		log.info("게시판 리스트 처리");
		
		model.addAttribute("list", boardListService.service(pageObject));
		model.addAttribute("pageObject", pageObject);
		return "board/list";
	}

	// 게시판 글보기
	@GetMapping("/view.do")
	public String view(long no, int inc) {
		log.info("게시판 글보기 - no: " + no + ", inc : " + inc);
		return "board/view";
	}

	// 게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("게시판 글쓰기 폼");
		return "board/write";
	}

	// 게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		log.info("게시판 글쓰기 처리 - vo : " + vo);
		return "redirect:list.do";
	}

	// 게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(long no) {
		log.info("게시판 수정 폼 - no : " + no);
		return "board/update";
	}

	// 게시판 글수정 처리
	@PostMapping("/update.do")
	public String update(BoardVO vo) {
		log.info("게시판 글수정 처리 - vo : " + vo);
		return "redirect:view.do?no=10";
	}

	// 게시판 글삭제
	@GetMapping("/delete.do")
	public String delete(long no) throws Exception {
		log.info("게시판 글삭제 처리 - no : " + no);
		return "redirect:list.do";
	}

}
