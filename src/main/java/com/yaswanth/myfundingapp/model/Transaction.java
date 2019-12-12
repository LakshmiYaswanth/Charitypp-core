package com.yaswanth.myfundingapp.model;

import java.sql.Date;


public class Transaction {
	
	private Integer requestId ;
	private Integer donorId ;
	private Integer amountfunded ;
	private Integer transactionId ;
	private Date fundedDate;
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public Integer getDonorId() {
		return donorId;
	}
	public void setDonorId(Integer donorId) {
		this.donorId = donorId;
	}
	public Integer getAmountfunded() {
		return amountfunded;
	}
	public void setAmountfunded(Integer amountfunded) {
		this.amountfunded = amountfunded;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "Transaction [requestId=" + requestId + ", donorId=" + donorId + ", amountfunded=" + amountfunded
				+ ", transactionId=" + transactionId + ", FundedDate=" + fundedDate + "]";
	}
	public Date getFundedDate() {
		return fundedDate;
	}
	public void setFundedDate(Date fundedDate) {
		this.fundedDate = fundedDate;
	}
	
}