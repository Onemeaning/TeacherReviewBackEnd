package com.meanlam.te.entity;


public class ThumbsCountsResult {

	private String commentId;//表示对哪一条评论操作
	private int everyCommentCounts;//表示对哪一个老师的哪一天评论的点赞数有多少
//	private boolean isPushedSupport;//表示当前评论，当前用户是否已经对他点赞过了

	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public int getEveryCommentCounts() {
		return everyCommentCounts;
	}
	public void setEveryCommentCounts(int everyCommentCounts) {
		this.everyCommentCounts = everyCommentCounts;
	}
	@Override
	public String toString() {
		return "ThumbsCountsResult [commentId=" + commentId + ", everyCommentCounts=" + everyCommentCounts + "]";
	}


	
	
}
