package com.cs545.zara.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recipient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String accountTypeFrom;
	private String accountTypeTo;
	
	//private String email;
	//private String phone;
	private String accountNumber;
	private String amount;
	//private String decription;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountTypeFrom() {
		return accountTypeFrom;
	}

	public void setAccountTypeFrom(String accountTypeFrom) {
		this.accountTypeFrom = accountTypeFrom;
	}

	public String getAccountTypeTo() {
		return accountTypeTo;
	}

	public void setAccountTypeTo(String accountTypeTo) {
		this.accountTypeTo = accountTypeTo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@ManyToOne
  //  @JoinColumn( = "user_id")
    //@JsonIgnore
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getuseruserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

//	public String getDecription() {
//		return decription;
//	}
//
//	public void setDecription(String decription) {
//		this.decription = decription;
//	}

	
	

}
