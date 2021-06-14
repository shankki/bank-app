package com.bankapp.portal.repository;

import com.bankapp.portal.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t from Transaction t where t.accountId=?1")
    List<Transaction> findTransactionsByAccountId(Integer accountId);

}
