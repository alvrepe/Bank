package org.iesfm.bank;

import org.iesfm.bank.exceptions.NotEnoughBalanceException;

public interface IBank {
    void withdraw(String nif, String iban, double amount) throws NotEnoughBalanceException;
    void transfer(String nif, String ibanOrigin, String ibanDestination, double amount);
}
