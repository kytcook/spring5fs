package com.meaningFarm.board.mapper;

import java.util.List;

import com.meaningFarm.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface BoardMapper {
	// 게시판 리스트
	public List<BoardVO> list(PageObject pageObject) throws Exception;
	
	// 전체 데이터 개수 가져오기
	public long getTotalRow(PageObject apgeObject) throws Exception;
	
}
