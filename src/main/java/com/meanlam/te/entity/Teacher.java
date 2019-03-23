package com.meanlam.te.entity;

public class Teacher {
	
	private String tId;
	private String tName;
	private String tAffiliation;
	private String tEmail;
	private String tIntroduction;
	private String tResearchInterest;
	private String tPublishedPaper;
	private String tProjects;
	private String tPhoto;
	private int tThumpUpCounts;
	private String tDetailLink;
	
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettAffiliation() {
		return tAffiliation;
	}
	public void settAffiliation(String tAffiliation) {
		this.tAffiliation = tAffiliation;
	}
	public String gettEmail() {
		return tEmail;
	}
	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}
	public String gettIntroduction() {
		return tIntroduction;
	}
	public void settIntroduction(String tIntroduction) {
		this.tIntroduction = tIntroduction;
	}
	public String gettResearchInterest() {
		return tResearchInterest;
	}
	public void settResearchInterest(String tResearchInterest) {
		this.tResearchInterest = tResearchInterest;
	}
	public String gettPublishedPaper() {
		return tPublishedPaper;
	}
	public void settPublishedPaper(String tPublishedPaper) {
		this.tPublishedPaper = tPublishedPaper;
	}
	public String gettProjects() {
		return tProjects;
	}
	public void settProjects(String tProjects) {
		this.tProjects = tProjects;
	}
	public String gettPhoto() {
		return tPhoto;
	}
	public void settPhoto(String tPhoto) {
		this.tPhoto = tPhoto;
	}
	public int gettThumpUpCounts() {
		return tThumpUpCounts;
	}
	public void settThumpUpCounts(int tThumpUpCounts) {
		this.tThumpUpCounts = tThumpUpCounts;
	}
	public String gettDetailLink() {
		return tDetailLink;
	}
	public void settDetailLink(String tDetailLink) {
		this.tDetailLink = tDetailLink;
	}
	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", tName=" + tName + ", tAffiliation=" + tAffiliation + ", tEmail=" + tEmail
				+ ", tIntroduction=" + tIntroduction + ", tResearchInterest=" + tResearchInterest
				+ ", tPublishedPaper=" + tPublishedPaper + ", tProjects=" + tProjects + ", tPhoto=" + tPhoto
				+ ", tThumpUpCounts=" + tThumpUpCounts + ", tDetailLink=" + tDetailLink + "]";
	}
	
}
