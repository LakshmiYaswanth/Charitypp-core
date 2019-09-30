package com.revature.myfundingapp.model;

public class Transaction {
	private Integer requestId ;
	private Integer donorId ;
	private Integer amountfunded ;
	private Integer transactionId ;
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
}