package com.eai.idss.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "consent_RESOURCES_comparison")
public class Consent_RESOURCES_comparison {
	
	@Id
	private String _id;
	private Double industryId;
	private String industryName;
	private String rawMaterialName;
	private Double uom;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate applicationCreatedOn;
	private double qty;
	private double waterConsumption;
	private double grossCapital;
	
	public double getWaterConsumption() {
		return waterConsumption;
	}

	public void setWaterConsumption(double waterConsumption) {
		this.waterConsumption = waterConsumption;
	}

	public double getGrossCapital() {
		return grossCapital;
	}

	public void setGrossCapital(double grossCapital) {
		this.grossCapital = grossCapital;
	}

	public LocalDate getApplicationCreatedOn() {
		return applicationCreatedOn;
	}

	public void setApplicationCreatedOn(LocalDate applicationCreatedOn) {
		this.applicationCreatedOn = applicationCreatedOn;
	}

	public Consent_RESOURCES_comparison() {

	}

	public Consent_RESOURCES_comparison(String _id, Double industryId, String industryName, String rawMaterialName,
			Double uom, String name,LocalDate applicationCreatedOn) {
		super();
		this._id = _id;
		this.industryId = industryId;
		this.industryName = industryName;
		this.rawMaterialName = rawMaterialName;
		this.uom = uom;
		this.name = name;
		this.applicationCreatedOn = applicationCreatedOn;
	}
	
	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
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

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getRawMaterialName() {
		return rawMaterialName;
	}

	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}

	public Double getUom() {
		return uom;
	}

	public void setUom(Double uom) {
		this.uom = uom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
