package org.iesfm.bank;

import org.iesfm.bank.exceptions.NotEnoughBalanceException;

import java.util.Objects;

public class Account {
    private String iban;
    private double balance;

    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }


    public void withdraw(double amount) throws NotEnoughBalanceException {
        if(balance < amount) {
            throw new NotEnoughBalanceException();
        } else {
            balance = balance - amount;
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance);
    }


}

