package com.cs545.zara.service;

import java.security.Principal;

import com.cs545.zara.domain.PrimaryAccount;
import com.cs545.zara.domain.SavingAccount;



public interface AccountService {

		//PrimaryAccount createPrimaryAccount();
	  //  SavingAccount createSavingsAccount();
	    void deposit(String accountType, double amount, Principal principal);
	    void withdraw(String accountType, double amount, Principal principal);
	    public PrimaryAccount createPrimaryAccount();
	    public SavingAccount createSavingAccount();
	    void  depositToSomeOneElse(String accountType, double amount, String accountNumber);
	    
	

}
