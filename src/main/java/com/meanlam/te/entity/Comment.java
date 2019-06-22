package com.meanlam.te.entity;

public class Comment {
	private String sourceId;
	private String uPhoto;
	private String uComments;
	private String uNickName;
	private String uInsertTime;
	private String tId;
	private int uType; //评论的情感分析,0负面、1中肯、2正面
	
	
	public int getuType() {
		return uType;
	}
	public void setuType(int uType) {
		this.uType = uType;
	}

	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getuPhoto() {
		return uPhoto;
	}
	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}
	public String getuComments() {
		return uComments;
	}
	public void setuComments(String uComments) {
		this.uComments = uComments;
	}
	public String getuNickName() {
		return uNickName;
	}
	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
	}
	public String getuInsertTime() {
		return uInsertTime;
	}
	public void setuInsertTime(String uInsertTime) {
		this.uInsertTime = uInsertTime;
	}

	
	
}
