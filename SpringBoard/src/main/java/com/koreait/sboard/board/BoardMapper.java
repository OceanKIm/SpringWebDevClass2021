package com.koreait.sboard.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.koreait.sboard.model.BoardPARAM;
import com.koreait.sboard.model.BoardSEL;

@Mapper
public interface BoardMapper {

	List<BoardSEL> selBoardList(BoardPARAM p);
	
	BoardSEL selBoard(BoardPARAM p);
	
	void del(BoardPARAM p);
	
	int reg(BoardPARAM p);
	
	int mod(BoardPARAM p);
 
	
}
