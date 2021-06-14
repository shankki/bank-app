# bank-app

1] Deposit Money : (If depositAmt > 0.01)
2] Withdraw money: [The withdraw amount should not be greater than available balance]
3] See account balance 
4] See transaction history

==================================================================================================

Assumptions:
1) Account Holders already exists
2) A user can have multiple accounts in the bank
3) For GET Apis it is assumed that User already exists [User exist check is not performed]
4) Spring Security is not implemented and so UserId is passed in the request for Deposite and Withdraw Money APIs
5) For Deposit and Withdraw only 1 API is maintained and logic is segrigated based on Transaction Type: Deposit/Withdraw
6) A standard response DTO is created for every Success and Exception response
==================================================================================================
Entities:

User
Accounts
Transactions

==================================================================================================

APIs and Endpoints:
1) User Transaction			|POST	| user/account/transaction

Request:
{
  "userId": ,
  "accountId": ,
  "transactionType":"Deposit",
  "amount": 
}

Response:
{
"data": ,
"message": 
}


2) Display balance			|GET	| user/{accountId}/balance

Request: NA

Response:
{
"data": ,
"message": 
}

3) Transaction History		|GET	| user/{accountId)/transaction-history

Request: NA

Response:
{
"data": ,
"message": 
}

==================================================================================================
Error Response: 
{
    "errorMessage": "",
    "httpStatus": "",
    "httpStatusCode": 
}
==================================================================================================

User
    Integer id        (Primary Key)
    String firstName
    String lastName
    String emailId  (unique)
    String password
    LocalDate createdDate
    Boolean isActive
 
 Account
    Integer id            (Primary Key)
    String accountNumber
    double balance
    LocalDate createdDate
    int userId            (Foreign Key)



Transaction
  
    Integer id            (Primary Key)
    int userId
    int accountId
    String transactionType
    double transactionAmount
    Boolean transactionStatus
    LocalDate transactionDate




