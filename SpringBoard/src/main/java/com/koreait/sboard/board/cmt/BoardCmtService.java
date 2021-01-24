package com.koreait.sboard.board.cmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.sboard.model.BoardCmtSEL;
import com.koreait.sboard.model.BoardPARAM;

@Service
public class BoardCmtService {

	@Autowired
	private BoardCmtMapper mapper;
	
	public List<BoardCmtSEL> selBoardCmtList(BoardPARAM p) {
		return mapper.selBoardCmtList(p);
	}
	
	// 댓글 작성
	public int cmtReg(BoardPARAM p) {
		return mapper.cmtReg(p);
	}
	
	// 댓글 수정
	public int cmtMod(BoardPARAM p) {
		return mapper.cmtMod(p);
	}
	
	// 댓글 삭제
	public int cmtDel(BoardPARAM p) {
		return mapper.cmtDel(p);
	}
}
