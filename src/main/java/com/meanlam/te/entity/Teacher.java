package com.meanlam.te.entity;

import java.util.List;
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
	private int tThumpUpCounts;//这个字段是需要名字的，现在不改名字了，将它代表为界面的访问数目
	private String tDetailLink;
	private List<String> projects;
	private List<String> papers;
	private List<String> years;
	
	public List<String> getProjects() {
		return projects;
	}
	public List<String> getYears() {
		return years;
	}
	public void setYears(List<String> years) {
		this.years = years;
	}
	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	public List<String> getPapers() {
		return papers;
	}
	public void setPapers(List<String> papers) {
		this.papers = papers;
	}
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
				+ ", tIntroduction=" + tIntroduction + ", tResearchInterest=" + tResearchInterest + ", tPublishedPaper="
				+ tPublishedPaper + ", tProjects=" + tProjects + ", tPhoto=" + tPhoto + ", tThumpUpCounts="
				+ tThumpUpCounts + ", tDetailLink=" + tDetailLink + ", projects=" + projects + ", papers=" + papers
				+ "]";
	}

	
	
}
