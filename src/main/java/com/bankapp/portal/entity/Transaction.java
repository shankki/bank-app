package com.bankapp.portal.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "txn_id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "account_id")
    private  Integer accountId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_amount")
    private  double transactionAmount;

    @Column(name = "transaction_status", columnDefinition ="boolean default false")
    private Boolean transactionStatus;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Boolean getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Boolean transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
