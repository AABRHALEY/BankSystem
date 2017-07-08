package com.cs545.zara.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cs545.zara.domain.PrimaryAccount;


@Repository
public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long>{

	PrimaryAccount findByAccountNumber (int accountNumber);
}
