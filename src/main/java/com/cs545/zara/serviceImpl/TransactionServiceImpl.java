package com.cs545.zara.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs545.zara.Exeption.BalanceIsInsufficientException;
import com.cs545.zara.domain.PrimaryTransaction;
import com.cs545.zara.domain.SavingTransaction;
import com.cs545.zara.domain.User;
import com.cs545.zara.repository.PrimaryTransactionDao;
import com.cs545.zara.repository.SavingTransactionDao;
import com.cs545.zara.service.TransactionService;
import com.cs545.zara.service.UserService;



@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PrimaryTransactionDao primaryTransactionDao;
	
	@Autowired
	private SavingTransactionDao savingTransactionDao;
	
	
	public List<PrimaryTransaction> findPrimaryTransactionList(String username){
        User user = userService.findByUsername(username);
        List<PrimaryTransaction> primaryTransactionList = user.getPrimaryAccount().getPrimaryTransactionList();
        

        return primaryTransactionList;
    }



	@Override
	public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {
		primaryTransactionDao.save(primaryTransaction);
		
		
	}

	@Override
	public void saveSavingDepositTransaction(SavingTransaction savingTransaction) {
		savingTransactionDao.save(savingTransaction);
		
	}

	@Override
	public void saveSavingWithDrawTransaction(SavingTransaction savingTransaction) {
		savingTransactionDao.save(savingTransaction);
		
	}

	@Override
	public void savePrimaryWithDrawTransaction(PrimaryTransaction primaryTransaction) {
		primaryTransactionDao.save(primaryTransaction);
		
	}



	@Override
	public List<SavingTransaction> findSavingTransactionList(String username) {
		User user = userService.findByUsername(username);
        List<SavingTransaction> savingTransactionList = user.getSavingAccount().getSavingTransactionList();
        

        return savingTransactionList;
		
	}
 
	
	
}
