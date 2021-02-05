package org.iesfm.bank;

import org.iesfm.bank.exceptions.NotEnoughBalanceException;
import org.iesfm.bank.exceptions.AccountNotFoundException;

public interface IBank {
    void withdraw(String nif, String iban, double amount) throws NotEnoughBalanceException, AccountNotFoundException;
    void transfer(String nif, String ibanOrigin, String ibanDestination, double amount) throws AccountNotFoundException, NotEnoughBalanceException;

}
