package com.koreait.sboard.model;

import org.apache.ibatis.type.Alias;

@Alias("BoardCmtSEL")
public class BoardCmtSEL extends BoardCmtEntity{
	
	private String writer_nm;

	public String getWriter_nm() {
		return writer_nm;
	}
	public void setWriter_nm(String writer_nm) {
		this.writer_nm = writer_nm;
	}
}
