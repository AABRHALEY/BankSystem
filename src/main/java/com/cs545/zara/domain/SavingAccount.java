package com.cs545.zara.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class SavingAccount {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private  int accountNumber;
	private BigDecimal accountBalance;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "savingAccount", cascade = CascadeType.ALL)
    //@JsonIgnore
	private List<SavingTransaction> savingTransactionList;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<SavingTransaction> getSavingTransactionList() {
		return savingTransactionList;
	}

	public void setSavingTransactionList(List<SavingTransaction> savingTransactionList) {
		this.savingTransactionList = savingTransactionList;
	}

	
	

}
