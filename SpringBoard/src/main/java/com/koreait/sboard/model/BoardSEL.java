package com.koreait.sboard.model;

import org.apache.ibatis.type.Alias;

@Alias("BoardSEL")
public class BoardSEL extends BoardEntity{
	private String writer_nm;
	
	// 좋아요
	private int favorite_cnt;
	private int is_favorite;
	
	// 페이징
	private int pageCntMax;
	
	public String getWriter_nm() {
		return writer_nm;
	}
	public void setWriter_nm(String writer_nm) {
		this.writer_nm = writer_nm;
	}
	public int getFavorite_cnt() {
		return favorite_cnt;
	}
	public void setFavorite_cnt(int favorite_cnt) {
		this.favorite_cnt = favorite_cnt;
	}
	public int getIs_favorite() {
		return is_favorite;
	}
	public void setIs_favorite(int is_favorite) {
		this.is_favorite = is_favorite;
	}
	public int getPageCntMax() {
		return pageCntMax;
	}
	public void setPageCntMax(int pageCntMax) {
		this.pageCntMax = pageCntMax;
	}
}
