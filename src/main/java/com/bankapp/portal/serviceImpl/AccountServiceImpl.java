package com.bankapp.portal.serviceImpl;

import com.bankapp.portal.dto.SuccessResponseDto;
import com.bankapp.portal.dto.TransactionRequestDto;
import com.bankapp.portal.entity.Account;
import com.bankapp.portal.entity.Transaction;
import com.bankapp.portal.entity.User;
import com.bankapp.portal.exception.InvalidInputParameterException;
import com.bankapp.portal.repository.AccountDao;
import com.bankapp.portal.repository.TransactionDao;
import com.bankapp.portal.repository.UserDao;
import com.bankapp.portal.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;


    /**
     * @param transactionRequest
     * @return user transaction status
     */
    @Override
    @Transactional
    public ResponseEntity userTransaction(TransactionRequestDto transactionRequest) {
        log.info("inside method depositMoney of AccountServiceImpl class");
        Optional<Account> account = accountDao.findById(transactionRequest.getAccountId());
        if (account.isPresent()) {
            Account acc = account.get();
            if (transactionRequest.getTransactionType().equalsIgnoreCase("Deposit")) {
                return depositMoneyResponse(transactionRequest, acc);
            }
            if (transactionRequest.getTransactionType().equalsIgnoreCase("Withdraw")) {
                return withdrawMoneyResponse(transactionRequest, account, acc);
            }
        } else {
            throw new EntityNotFoundException("Account details not found for account id : " + transactionRequest.getAccountId());
        }
        return new ResponseEntity("Method not implemented", HttpStatus.NOT_IMPLEMENTED);
    }

    private ResponseEntity<SuccessResponseDto> withdrawMoneyResponse(TransactionRequestDto transactionRequest, Optional<Account> account, Account acc) {
        if ((transactionRequest.getAmount() < account.get().getBalance()) && (account.get().getBalance() > 0.01)) {
            acc.setBalance((acc.getBalance() - transactionRequest.getAmount()));
            accountDao.save(acc);
            log.info("Money deducted successfully.");
            updateTxnDetails(transactionRequest);
            return ResponseEntity.ok(new SuccessResponseDto("Dear, " + acc.getUser().getFirstName() + "Your withdrawn Successfully!", "Your updated account balance is : " + acc.getBalance()));
        } else {
            throw new InvalidInputParameterException("Transaction failed as available balance in your account is less than your withdraw amount request");
        }
    }

    private ResponseEntity<SuccessResponseDto> depositMoneyResponse(TransactionRequestDto transactionRequest, Account acc) {
        if ((transactionRequest.getAmount() > 0.01)) {
            acc.setBalance((acc.getBalance() + transactionRequest.getAmount()));
            accountDao.save(acc);
            log.info("Amount deposited successfully!");
            updateTxnDetails(transactionRequest);
            return ResponseEntity.ok(new SuccessResponseDto("Dear ," + acc.getUser().getFirstName(),
                    "Your money is deposited Successfully!"));
        } else {
            throw new InvalidInputParameterException("The deposit amount cannot be less than 0.01 rupees");
        }
    }

    private void updateTxnDetails(TransactionRequestDto transactionRequest) {
        log.info("updating transaction details for account id {} : ", transactionRequest.getAccountId());
        Transaction transaction = new Transaction();
        transaction.setAccountId(transactionRequest.getAccountId());
        transaction.setTransactionType(transactionRequest.getTransactionType());
        transaction.setTransactionDate(LocalDate.now());
        transaction.setUserId(transactionRequest.getUserId());
        transaction.setTransactionAmount(transactionRequest.getAmount());
        transaction.setTransactionStatus(true);
        transactionDao.save(transaction);
        log.info("transaction details saved successfully!");
    }

    /**
     * <p>This method is used to check if the user with given id exist or not</p>
     *
     * @param userId
     * @return boolean value
     */
    @Override
    public boolean userExists(int userId) {
        log.info("inside method userExist of class AccountServiceImpl");
        Optional<User> user = userDao.findById(userId);
        log.info("user for userId {} : , found {} : ", userId, user.isPresent());
        return user.isPresent();
    }



}
