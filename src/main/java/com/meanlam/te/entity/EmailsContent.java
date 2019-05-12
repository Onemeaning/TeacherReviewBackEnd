package com.meanlam.te.entity;

import java.util.Arrays;

public class EmailsContent {
	
	private String fromId;
	private String fromIdImage;
	private String fromIdNickName;
	private String toId;
	private String sendTime;
	private String emailContent;
	private boolean checked;//邮件是否被查看的状态，false表示没有被查看
	private byte[] file;//保存上传的简历完文件
	private String resumeUrl;//获取URL的时候给这个赋值;
	
	
	public String getResumeUrl() {
		return resumeUrl;
	}
	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getFromIdImage() {
		return fromIdImage;
	}
	public void setFromIdImage(String fromIdImage) {
		this.fromIdImage = fromIdImage;
	}
	public String getFromIdNickName() {
		return fromIdNickName;
	}
	public void setFromIdNickName(String fromIdNickName) {
		this.fromIdNickName = fromIdNickName;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "EmailsContent [fromId=" + fromId + ", fromIdImage=" + fromIdImage + ", fromIdNickName=" + fromIdNickName
				+ ", toId=" + toId + ", sendTime=" + sendTime + ", emailContent=" + emailContent + ", checked="
				+ checked + ", file=" + Arrays.toString(file) + "]";
	}
	
	

}
