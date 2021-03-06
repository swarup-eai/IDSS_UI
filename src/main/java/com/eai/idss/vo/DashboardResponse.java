package com.eai.idss.vo;

import java.util.List;
import java.util.Map;

public class DashboardResponse {

	private Map<String,Map<String,List<TileVo>>> dashboardMap;
	private Map<String,List<TopPerfVo>> topPerformers;
	private List<MyVisits> myVisits;
	private Double industryScore;
	private List<IndustryCscoreResponseVo> industryCscoreDetails;
	public List<IndustryCscoreResponseVo> getIndustryCscoreDetails() {
		return industryCscoreDetails;
	}
	public void setIndustryCscoreDetails(List<IndustryCscoreResponseVo> industryCscoreDetails) {
		this.industryCscoreDetails = industryCscoreDetails;
	}
	public Map<String, Map<String, List<TileVo>>> getDashboardMap() {
		return dashboardMap;
	}
	public void setDashboardMap(Map<String, Map<String, List<TileVo>>> dashboardMap) {
		this.dashboardMap = dashboardMap;
	}
	public Map<String,List<TopPerfVo>> getTopPerformers() {
		return topPerformers;
	}
	public void setTopPerformers(Map<String,List<TopPerfVo>> topPerformers) {
		this.topPerformers = topPerformers;
	}
	public List<MyVisits> getMyVisits() {
		return myVisits;
	}
	public void setMyVisits(List<MyVisits> myVisits) {
		this.myVisits = myVisits;
	}
	public Double getIndustryScore() {
		return industryScore;
	}
	public void setIndustryScore(Double industryScore) {
		this.industryScore = industryScore;
	}

}
