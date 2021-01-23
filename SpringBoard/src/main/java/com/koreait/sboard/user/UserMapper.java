package com.koreait.sboard.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.koreait.sboard.model.UserEntity;

@Mapper
public interface UserMapper {
	
	// 전체 유저 정보 가져오기 - 연습
	List<UserEntity> selUserList();
	
	// 회원가입 proc
	void insUser(UserEntity param);
	
	// 로그인 proc
	UserEntity selUser(UserEntity param);
	
}

