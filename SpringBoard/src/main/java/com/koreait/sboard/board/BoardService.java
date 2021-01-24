package com.koreait.sboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.sboard.model.BoardPARAM;
import com.koreait.sboard.model.BoardSEL;


@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;

	List<BoardSEL> selBoardList(BoardPARAM p) {
		return mapper.selBoardList(p);
	}
	
	BoardSEL selBoard(BoardPARAM p) {
		return mapper.selBoard(p);
	}
	
	BoardSEL selPageCntMax(BoardPARAM p) {
		return mapper.selPageCntMax(p);
	}
	
	void del(BoardPARAM p) {
		mapper.del(p);
	}
	
	int reg(BoardPARAM p) {
		return mapper.reg(p);
	}
	
	int mod(BoardPARAM p) {
		return mapper.mod(p);
	}
	
	int insFavorite(BoardPARAM p) {
		return mapper.insFavorite(p);
	}
	
	int delFavortie(BoardPARAM p) {
		return mapper.delFavortie(p);
	}
	
}




















