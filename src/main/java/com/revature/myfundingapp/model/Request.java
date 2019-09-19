package com.revature.myfundingapp.model;



import java.time.LocalDate;


public class Request{
	private Integer id ;
	private String Fund_type;
	private Integer Amount;
	private String active;
	private Integer Amountneeded;
	public Integer getAmountneeded() {
		return Amountneeded;
	}
	public void setAmountneeded(Integer amountneeded) {
		Amountneeded = amountneeded;
	}
	private LocalDate Announced_date;
	private LocalDate Expire_date;
	private  Integer Admin_id ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFund_type() {
		return Fund_type;
	}
	public void setFund_type(String fund_type) {
		Fund_type = fund_type;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public LocalDate getAnnounced_date() {
		return Announced_date;
	}
	public void setAnnounced_date(LocalDate announced_date) {
		Announced_date = announced_date;
	}
	public LocalDate getExpire_date() {
		return Expire_date;
	}
	public void setExpire_date(LocalDate Expire_date) {
		this.Expire_date = Expire_date;
	}
	public Integer getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		Admin_id = admin_id;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", Fund_type=" + Fund_type + ", Amount=" + Amount + ", active=" + active
				+ ", Amountneeded=" + Amountneeded + ", Announced_date=" + Announced_date + ", Expire_date="
				+ Expire_date + ", Admin_id=" + Admin_id + "]";
	}
	
	}
