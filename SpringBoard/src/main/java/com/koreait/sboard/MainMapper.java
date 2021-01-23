package com.koreait.sboard;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreait.sboard.model.ManagerBoardEntity;

@Mapper
public interface MainMapper {
	
	List<ManagerBoardEntity> selManagerBoardList();

}
