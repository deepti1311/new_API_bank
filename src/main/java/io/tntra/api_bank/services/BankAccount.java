package io.tntra.api_bank.services;


import io.tntra.api_bank.Exceptions.*;

import java.math.BigDecimal;

public interface BankAccount {

    public void Widthdraw(BigDecimal balance) throws InsufficientBalanceException;

    public BigDecimal Deposite(BigDecimal balance);

    public boolean checkBalance(BigDecimal amount);

}
