package io.tntra.api_bank.services;


import java.math.BigDecimal;

import io.tntra.api_bank.Enum.pkg.AccountType;
import io.tntra.api_bank.Exceptions.*;

public abstract class account implements BankAccount {

    public String owner;
    public BigDecimal balance;
    public BigDecimal min_balance = BigDecimal.valueOf(0);
    private BigDecimal overDraft = BigDecimal.valueOf(0);

    public AccountType account_type;

    protected account(String owner, BigDecimal balance, BigDecimal min_balance, AccountType account_type) {
        this.owner = owner;
        this.balance = balance;
        this.min_balance = min_balance;
        System.out.println(getClass().getSimpleName() + " Transaction Details :");
        System.out.println(owner + " Available balance was:rs " + balance);
        this.account_type = account_type;
    }

    @Override
    public BigDecimal Deposite(BigDecimal amount) {

        min_balance = amount;
        System.out.println("Deposited amount is:rs " + amount);

        this.balance = balance.add(amount);
        return balance;

    }

    @Override
    public void Widthdraw(BigDecimal amount) throws InsufficientBalanceException {
        System.out.println("Widthdraw amount is:rs " + amount);
        try {
            if (checkBalance(amount)) {
                this.balance = this.balance.subtract(amount);
            } else
                throw new InsufficientBalanceException("Insufficient Balance FOR TRANSACTIONS!!");
        } catch (InsufficientBalanceException e) {
            e.getMessage();
            throw new InsufficientBalanceException("Insufficient Balance FOR TRANSACTIONS!!");
        }

    }

    @Override
    public boolean checkBalance(BigDecimal amount) {
        if (this.account_type == AccountType.CURRENT) {
            BigDecimal temp = this.balance.add(this.overDraft);
            return temp.compareTo(amount) >= 0;
        }
        return this.balance.compareTo(amount) >= 0;
    }

    public String getowner(String owner) {
        return this.owner = owner;

    }

    public BigDecimal getbalance(BigDecimal balance) {
        return this.balance = balance;
    }

    public void set(String owner, BigDecimal balance) {

        this.owner = owner;
        this.balance = balance;
    }

    public void setMinBalance(BigDecimal bal) {
        this.min_balance = bal;
    }

    public void setOverDraft(BigDecimal amt) {
        this.overDraft = amt;
    }

}
