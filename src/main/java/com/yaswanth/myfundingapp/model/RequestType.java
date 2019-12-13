package com.yaswanth.myfundingapp.model;

public class RequestType {
	Integer fundTypeId;
	String fundType;
	public Integer getFundTypeId() {
		return fundTypeId;
	}
	public void setFundTypeId(Integer fundTypeId) {
		this.fundTypeId = fundTypeId;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	@Override
	public String toString() {
		return "RequestType [fundTypeId=" + fundTypeId + ", fundType=" + fundType + "]";
	}

}
