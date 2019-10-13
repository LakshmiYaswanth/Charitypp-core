package com.revature.myfundingapp.model;

import java.time.LocalDate;

public class Request{
	
	private Integer requestId ;
	private String fundType;
	private Integer amount;
	private Integer amountneeded;
	private LocalDate announcedDate;
	private LocalDate expireDate;
	private  Integer adminId ;
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", fundType=" + fundType + ", amount=" + amount + 
			"+ amountneeded=" + amountneeded + ", announcedDate=" + announcedDate + ", expireDate="
				+ expireDate + ", adminId=" + adminId + "]";
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
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
}