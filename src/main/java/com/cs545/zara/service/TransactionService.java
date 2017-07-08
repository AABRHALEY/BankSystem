package com.cs545.zara.service;

import java.util.List;

import com.cs545.zara.domain.PrimaryTransaction;
import com.cs545.zara.domain.SavingTransaction;



public interface TransactionService {
	
	List<PrimaryTransaction> findPrimaryTransactionList(String username);  
	List<SavingTransaction> findSavingTransactionList(String username);
	
	void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);
     void saveSavingDepositTransaction(SavingTransaction savingsTransaction);
	 
     void savePrimaryWithDrawTransaction(PrimaryTransaction primaryTransaction);
     void saveSavingWithDrawTransaction(SavingTransaction savingsTransaction);

}
