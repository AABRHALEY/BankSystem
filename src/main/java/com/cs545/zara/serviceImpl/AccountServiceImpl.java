package com.cs545.zara.serviceImpl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs545.zara.Exeption.BalanceIsInsufficientException;
import com.cs545.zara.domain.PrimaryAccount;
import com.cs545.zara.domain.PrimaryTransaction;
import com.cs545.zara.domain.SavingAccount;
import com.cs545.zara.domain.SavingTransaction;
import com.cs545.zara.domain.User;
import com.cs545.zara.repository.PrimaryAccountDao;
import com.cs545.zara.repository.SavingAccountDao;
import com.cs545.zara.service.AccountService;
import com.cs545.zara.service.TransactionService;
import com.cs545.zara.service.UserService;



@Transactional
@Service
public class AccountServiceImpl implements AccountService {
	private static int nextAccountNumber = 11223145;
	
	  @Autowired
	    private PrimaryAccountDao primaryAccountDao;

	    @Autowired
	    private SavingAccountDao savingAccountDao;

	    @Autowired
	    private UserService userService;
	    
	    @Autowired
	    private TransactionService transactionService;
	    
	    public PrimaryAccount createPrimaryAccount() {
	        PrimaryAccount primaryAccount = new PrimaryAccount();
	        primaryAccount.setAccountBalance(new BigDecimal(0.0));
	        primaryAccount.setAccountNumber(accountGen());

	        primaryAccountDao.save(primaryAccount);

	        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
	    }

	    public SavingAccount createSavingAccount() {
	        SavingAccount savingsAccount = new SavingAccount();
	        savingsAccount.setAccountBalance(new BigDecimal(0.0));
	        savingsAccount.setAccountNumber(accountGen());

	        savingAccountDao.save(savingsAccount);

	        return savingAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
	    }
	    
	    public void deposit(String accountType,double amount,Principal principal){
	    	User user=userService.findByUsername(principal.getName());
	    	
	    	if(accountType.equalsIgnoreCase("Saving")){
	    		SavingAccount savingAccount=user.getSavingAccount();
	    		savingAccount.setAccountBalance(savingAccount.getAccountBalance().add(new BigDecimal(amount)));
	    		savingAccountDao.save(savingAccount);
	    		
	    		Date date=new Date();
	    		SavingTransaction savingTransaction = new SavingTransaction(date, "Deposit to savings Account", "SavingsAccount", "Finished", amount, savingAccount.getAccountBalance(), savingAccount);
	            transactionService.saveSavingDepositTransaction(savingTransaction);
	    	}else{

		    	if(accountType.equalsIgnoreCase("Primary")){
		    		//System.out.println("reached");
		    		PrimaryAccount primaryAccount=user.getPrimaryAccount();
		    		primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
		    		primaryAccountDao.save(primaryAccount);
		    		
		    		Date date=new Date();
	    		PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit to Primary Account", "PrimaryAccount", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
	    		transactionService.savePrimaryDepositTransaction(primaryTransaction);
		    	}
	    	}
	    	
	    	
	    }
	    public void withdraw(String accountType, double amount, Principal principal) {
	        User user = userService.findByUsername(principal.getName());
	       
  
	        if (accountType.equalsIgnoreCase("Primary")) {
	            PrimaryAccount primaryAccount = user.getPrimaryAccount();
	        
	            
	            		if(primaryAccount.getAccountBalance().doubleValue() < amount){
	    			throw new BalanceIsInsufficientException(user.getUsername());
	    		}
	            
	            
	            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
	            primaryAccountDao.save(primaryAccount);

	            Date date = new Date();

	            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Withdraw from Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
	            transactionService.savePrimaryWithDrawTransaction(primaryTransaction);
	            
	            
	        } else if (accountType.equalsIgnoreCase("Saving")) {
	            SavingAccount savingsAccount = user.getSavingAccount();
	            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
	            savingAccountDao.save(savingsAccount);

	            Date date = new Date();
	            SavingTransaction savingsTransaction = new SavingTransaction(date, "Withdraw from savings Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
	            transactionService.saveSavingWithDrawTransaction(savingsTransaction);
	        }
	    }
	    
	    private int accountGen() {
	        return ++nextAccountNumber;
	    }

		@Override
		public void depositToSomeOneElse(String accountType, double amount, String accountNumber1) {
			int accountNumber= Integer.parseInt(accountNumber1);
;			
			if(accountType.equalsIgnoreCase("Saving")){
				SavingAccount savingAccount=savingAccountDao.findByAccountNumber(accountNumber);
	    		//SavingAccount savingAccount=user.getSavingAccount();
	    		savingAccount.setAccountBalance(savingAccount.getAccountBalance().add(new BigDecimal(amount)));
	    		savingAccountDao.save(savingAccount);
	    		
	    		Date date=new Date();
	    		SavingTransaction savingTransaction = new SavingTransaction(date, "Deposit From Anothor Account", "SavingsAccount", "Finished", amount, savingAccount.getAccountBalance(), savingAccount);
	            transactionService.saveSavingDepositTransaction(savingTransaction);
	    	}else{

		    	if(accountType.equalsIgnoreCase("Primary")){
		    		PrimaryAccount primaryAccount=primaryAccountDao.findByAccountNumber(accountNumber);
		    		//System.out.println("reached");
		    		//PrimaryAccount primaryAccount=user.getPrimaryAccount();
		    		primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
		    		primaryAccountDao.save(primaryAccount);
		    		
		    		Date date=new Date();
	    		PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit From Anothor Account", "PrimaryAccount", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
	    		transactionService.savePrimaryDepositTransaction(primaryTransaction);
		    	}
	    	}
			
		}
}
