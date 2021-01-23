package com.koreait.sboard.common;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import com.koreait.sboard.model.UserEntity;

@Component
public class SecurityUtils {
	
	//true: 로그아웃 상태, false: 로그인 상태  -> 필요 없음. 로그인 안 해도 다 허용.
	public  boolean isLogin(HttpSession hs) {
		return getLoginUser(hs) != null;
	}
	
	public UserEntity getLoginUser(HttpSession hs) {
		return (UserEntity)hs.getAttribute("loginUser");
	}
	
	public int getLoginUserPk(HttpSession hs) {
		UserEntity loginUser = getLoginUser(hs);
		return loginUser == null ? 0 : loginUser.getI_user();
	}

}