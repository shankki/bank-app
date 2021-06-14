package com.bankapp.portal.dto;

import javax.validation.constraints.NotNull;

public class TransactionRequestDto {


    @NotNull(message = "User id cannot be null")
    private Integer userId;

    @NotNull(message = "Account id cannot be null")
    private Integer accountId;

    @NotNull(message = "Transaction Type cannot be null")
    private String transactionType;

    @NotNull(message = "amount cannot be null")
    private Double amount;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionRequestDto{" +
                "userId=" + userId +
                ", accountId=" + accountId +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }


}
