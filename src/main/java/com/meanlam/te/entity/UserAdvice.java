package com.meanlam.te.entity;

import java.util.Arrays;

public class UserAdvice {

	private String userId;
	private String adviceType;
	private String adviceContent;
	private String adviceTime;
	private byte[] advicePhoto;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAdviceType() {
		return adviceType;
	}
	public void setAdviceType(String adviceType) {
		this.adviceType = adviceType;
	}
	public String getAdviceContent() {
		return adviceContent;
	}
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	public String getAdviceTime() {
		return adviceTime;
	}
	public void setAdviceTime(String adviceTime) {
		this.adviceTime = adviceTime;
	}
	public byte[] getAdvicePhoto() {
		return advicePhoto;
	}
	public void setAdvicePhoto(byte[] advicePhoto) {
		this.advicePhoto = advicePhoto;
	}
	@Override
	public String toString() {
		return "UserAdvice [userId=" + userId + ", adviceType=" + adviceType + ", adviceContent=" + adviceContent
				+ ", adviceTime=" + adviceTime + ", advicePhoto=" + Arrays.toString(advicePhoto) + "]";
	}
	
	
}
