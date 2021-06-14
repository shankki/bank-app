package com.bankapp.portal.controller;


import com.bankapp.portal.dto.TransactionRequestDto;
import com.bankapp.portal.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    @Autowired
    public AccountController (AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/account/transaction")
    public ResponseEntity<?> userMoneyTransaction(@Valid @RequestBody TransactionRequestDto transactionRequest, Errors errors){
        log.info("Initiate userMoneyTransaction method inside AccountController with request parameter {} : ", transactionRequest.toString());
        if (!accountService.userExists(transactionRequest.getUserId())){
            throw new EntityNotFoundException("User not found with user id : "+transactionRequest.getUserId() );
        }
        if (errors.hasErrors()) {
            List<String> validationMessages =  errors.getAllErrors().stream().map(e->e.getDefaultMessage()).collect(Collectors.toList());
            return ResponseEntity.badRequest().body(validationMessages);
        }
        return accountService.userTransaction(transactionRequest);
    }


    @GetMapping("/{accountId}/balance")
    public ResponseEntity<?> checkAccountBalance(@NotNull @PathVariable Integer accountId){
        log.info("inside checkAccountBalance method of AccountController with account id {} : ", accountId);
        return accountService.getAccountBalance(accountId);
    }


    @GetMapping("/{accountId}/transaction-history")
    public ResponseEntity<?> checkUserTransactionHistory(@NotNull @PathVariable Integer accountId){
        log.info("inside checkUserTransactionHistory method of AccountController with account id {} : ", accountId);
        return accountService.getUserAccountTransactionHistory(accountId);
    }


}
