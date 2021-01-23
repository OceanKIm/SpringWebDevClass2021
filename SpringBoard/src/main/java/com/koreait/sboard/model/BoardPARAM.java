package com.koreait.sboard.model;

import org.apache.ibatis.type.Alias;

@Alias("BoardPARAM")
public class BoardPARAM extends BoardEntity{
	
	// detail 처리
	private int i_user;
	// 페이징 처리
	private int setPageCnt;
	private int nowPageCnt;
	
	public int getSetPageCnt() {
		return setPageCnt;
	}
	public void setSetPageCnt(int setPageCnt) {
		this.setPageCnt = setPageCnt;
	}
	public int getNowPageCnt() {
		return nowPageCnt;
	}
	public void setNowPageCnt(int nowPageCnt) {
		this.nowPageCnt = nowPageCnt;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	
}
