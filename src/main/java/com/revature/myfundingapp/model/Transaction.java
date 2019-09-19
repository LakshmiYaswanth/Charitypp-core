package com.revature.myfundingapp.model;

public class Transaction {
	private Integer id ;
	private Integer donor_id ;
	private Integer amountfunded ;
	private Integer transaction_id ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(Integer donor_id) {
		this.donor_id = donor_id;
	}
	public Integer getAmountfunded() {
		return amountfunded;
	}
	public void setAmountfunded(Integer amountfunded) {
		this.amountfunded = amountfunded;
	}
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", donor_id=" + donor_id + ", amountfunded=" + amountfunded
				+ ", transaction_id=" + transaction_id + "]";
	}
}