package com.koreait.sboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.sboard.model.ManagerBoardEntity;

@Service
public class MainService {

	@Autowired
	private MainMapper mapper;
	
	public List<ManagerBoardEntity> selManagerBoardList(){
		//System.out.println("###service:메뉴뿌리기");
		return mapper.selManagerBoardList();
	}
	
	
}
