package com.eai.idss.vo;

public class MyVisitsIndustries {

	private int industryId;
	private String industryName;
	private int cScore;
	private String visitStatus;
	
	public String getVisitStatus() {
		return visitStatus;
	}
	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public int getcScore() {
		return cScore;
	}
	public void setcScore(int cScore) {
		this.cScore = cScore;
	}
	public int getIndustryId() {
		return industryId;
	}
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	
}
