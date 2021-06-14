package com.bankapp.portal.service;

import com.bankapp.portal.dto.SuccessResponseDto;
import com.bankapp.portal.dto.TransactionRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface AccountService {


    SuccessResponseDto userTransaction(TransactionRequestDto depositMoneyRequest);

    boolean userExists(int userId);

    SuccessResponseDto getAccountBalance(Integer accountId);

    SuccessResponseDto getUserAccountTransactionHistory(Integer accountId);

}
