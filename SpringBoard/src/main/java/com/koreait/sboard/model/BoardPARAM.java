package com.koreait.sboard.model;

import org.apache.ibatis.type.Alias;

@Alias("BoardPARAM")
public class BoardPARAM extends BoardEntity{
	
	// detail 처리
	private int i_user;
	
	// 페이징 처리
	private int line;
	private int page;
	
	// 댓글 처리
	private int i_cmt;
	private int emp;
	private int unemp;
	
	// 아작스 favorite
	private int state;
	
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}

	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getI_cmt() {
		return i_cmt;
	}
	public void setI_cmt(int i_cmt) {
		this.i_cmt = i_cmt;
	}
	public int getEmp() {
		return emp;
	}
	public void setEmp(int emp) {
		this.emp = emp;
	}
	public int getUnemp() {
		return unemp;
	}
	public void setUnemp(int unemp) {
		this.unemp = unemp;
	}
}
