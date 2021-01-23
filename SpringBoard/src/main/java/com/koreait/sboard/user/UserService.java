package com.koreait.sboard.user;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.sboard.MainService;
import com.koreait.sboard.model.UserEntity;

@Service
public class UserService {	
	
	@Autowired
	private UserMapper mapper;
	
	// 유저 정보 proc
	public List<UserEntity> selUserList() {
		return mapper.selUserList();
	}
	
	// 회원 가입 proc
	public void insUser(UserEntity param) {
		mapper.insUser(param);
	}
	
	// 로그인 proc
	public UserEntity selUser(UserEntity param) {
		return mapper.selUser(param);
	}
}