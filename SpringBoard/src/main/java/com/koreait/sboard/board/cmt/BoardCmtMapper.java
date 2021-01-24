package com.koreait.sboard.board.cmt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.sboard.model.BoardCmtSEL;
import com.koreait.sboard.model.BoardPARAM;

@Mapper
public interface BoardCmtMapper {
	
	int cmtReg(BoardPARAM p);
	
	List<BoardCmtSEL> selBoardCmtList(BoardPARAM p);
	
	int cmtMod(BoardPARAM p);
	
	int cmtDel(BoardPARAM p);
	
}
