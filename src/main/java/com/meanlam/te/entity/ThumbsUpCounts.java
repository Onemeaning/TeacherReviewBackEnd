package com.meanlam.te.entity;

import java.math.BigInteger;

public class ThumbsUpCounts {
	private String sourceId;
	private String destId;
	private BigInteger thumpsUpTime;
	
	private String teacherUniqueId;
	private String commentId;//每条评论的ID，这个值由评论人ID+评论时间组成
	
	
	public String getTeacherUniqueId() {
		return teacherUniqueId;
	}
	public void setTeacherUniqueId(String teacherUniqueId) {
		this.teacherUniqueId = teacherUniqueId;
	}
	
	
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getSourceId() {
		return sourceId;
	}
		
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getDestId() {
		return destId;
	}
	public void setDestId(String destId) {
		this.destId = destId;
	}
	public BigInteger getThumpsUpTime() {
		return thumpsUpTime;
	}
	public void setThumpsUpTime(BigInteger thumpsUpTime) {
		this.thumpsUpTime = thumpsUpTime;
	}
	@Override
	public String toString() {
		return "ThumbsUpCounts [sourceId=" + sourceId + ", destId=" + destId + ", thumpsUpTime=" + thumpsUpTime
				+ ", teacherUniqueId=" + teacherUniqueId + ", commentId=" + commentId + "]";
	}
	
	
	
	
}
