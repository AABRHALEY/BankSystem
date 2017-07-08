package com.cs545.zara.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs545.zara.domain.SavingAccount;

@Repository
public interface SavingAccountDao extends CrudRepository<SavingAccount, Long> {

    SavingAccount findByAccountNumber (int accountNumber);
}
