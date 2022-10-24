package com.meaningFarm.board.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meaningFarm.board.mapper.BoardMapper;
import com.meaningFarm.taek.Service;
import com.webjjang.util.PageObject;

// 자동생성 - @Controller, @Service, @Repository, @Component, @RestController
@org.springframework.stereotype.Service
public class BoardListService implements Service{
	private static final Logger log = LoggerFactory.getLogger(BoardListService.class);
	
	private BoardMapper mapper;
	
	@Inject
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}

	
	@Override
	public Object service(Object obj) throws Exception {
		PageObject pageObject = (PageObject) obj;
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		log.info("pageObject - " + pageObject);
		return mapper.list(pageObject);
	}

}
