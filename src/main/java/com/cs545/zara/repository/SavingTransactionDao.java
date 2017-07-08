package com.cs545.zara.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cs545.zara.domain.SavingTransaction;


@Repository
public interface SavingTransactionDao extends CrudRepository<SavingTransaction, Long> {

    List<SavingTransaction> findAll();
}

