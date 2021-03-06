package com.eai.idss.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "esr_RESOURCES_comparison")
public class ESR_RESOURCES_comparison {
	@Id
	private String _id;
	private Double industryId;
	private String companyName;
	private Double uom;
	private String rawMaterialName;
	private String name;
	private int finantialYear;
	private double rawMaterialQty;
	private double waterConsumptionTotalQuantityActual;
	private double capitalInvestment;
	
	public double getWaterConsumptionTotalQuantityActual() {
		return waterConsumptionTotalQuantityActual;
	}

	public void setWaterConsumptionTotalQuantityActual(double waterConsumptionTotalQuantityActual) {
		this.waterConsumptionTotalQuantityActual = waterConsumptionTotalQuantityActual;
	}

	public double getCapitalInvestment() {
		return capitalInvestment;
	}

	public void setCapitalInvestment(double capitalInvestment) {
		this.capitalInvestment = capitalInvestment;
	}

	public ESR_RESOURCES_comparison() {

	}

	public ESR_RESOURCES_comparison(String _id, Double industryId, String companyName, Double uom,
			String rawMaterialName, String name,int finantialYear) {
		super();
		this._id = _id;
		this.industryId = industryId;
		this.companyName = companyName;
		this.uom = uom;
		this.rawMaterialName = rawMaterialName;
		this.name = name;
		this.finantialYear=finantialYear;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getFinantialYear() {
		return finantialYear;
	}

	public void setFinantialYear(int finantialYear) {
		this.finantialYear = finantialYear;
	}

	public double getRawMaterialQty() {
		return rawMaterialQty;
	}

	public void setRawMaterialQty(double rawMaterialQty) {
		this.rawMaterialQty = rawMaterialQty;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Double getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Double industryId) {
		this.industryId = industryId;
	}

	public String getCompanyname() {
		return companyName;
	}

	public void setCompanyname(String companyName) {
		this.companyName = companyName;
	}

	public Double getUom() {
		return uom;
	}

	public void setUom(Double uom) {
		this.uom = uom;
	}

	public String getRawMaterialName() {
		return rawMaterialName;
	}

	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFinantialyear() {
		return finantialYear;
	}

	public void setFinantialyear(int finantialYear) {
		this.finantialYear = finantialYear;
	}

	

}
