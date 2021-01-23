package com.koreait.sboard.model;

import org.apache.ibatis.type.Alias;

@Alias("ManagerBoardEntity")
public class ManagerBoardEntity {
	private int typ;
	private String nm;
	
	public int getTyp() {
		return typ;
	}
	public void setTyp(int typ) {
		this.typ = typ;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
}
