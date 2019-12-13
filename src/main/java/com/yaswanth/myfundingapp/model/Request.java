package com.yaswanth.myfundingapp.model;

import java.time.LocalDate;

public class Request{
	
	private Integer requestId ;
	private Integer fundType_Id;
	private Integer amount;
	private Integer amountneeded;
	private LocalDate announcedDate;
	private LocalDate expireDate;
	private  Integer adminId ;
	private String description;
	private String status;
	private RequestType requestType;
	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", fundTypeId=" + fundType_Id + ", amount=" + amount
				+ ", amountneeded=" + amountneeded + ", announcedDate=" + announcedDate + ", expireDate=" + expireDate
				+ ", adminId=" + adminId + ", description=" + description + ", status=" + status + ", requestType="
				+ requestType + "]";
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public Integer getFundTypeId() {
		return fundType_Id;
	}
	public void setFundTypeId(Integer fundType_Id) {
		this.fundType_Id = fundType_Id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getAmountneeded() {
		return amountneeded;
	}
	public void setAmountneeded(Integer amountneeded) {
		this.amountneeded = amountneeded;
	}
	public LocalDate getAnnouncedDate() {
		return announcedDate;
	}
	public void setAnnouncedDate(LocalDate announcedDate) {
		this.announcedDate = announcedDate;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}