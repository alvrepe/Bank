package org.iesfm.bank;

import org.iesfm.bank.exceptions.NotEnoughBalanceException;

import java.util.Arrays;
import java.util.Objects;

public class Client {
    private String nif;
    private String name;
    private String surname;
    private Account[] accounts;

    public Client(String nif, String name, String surname, Account[] accounts) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
    }

    public void withdraw(String iban, double amount) throws NotEnoughBalanceException {
        Account account = findAccount(iban);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("No existe la cuenta con iban " + iban);
        }
    }

    public void transfer(String ibanOrigin, String ibanDestination, double amount) {
        Account accountOrigin = findAccount(ibanOrigin);
        Account accountDestination = findAccount(ibanDestination);
        if (accountOrigin != null && accountDestination != null) {
            try {
                accountOrigin.withdraw(amount);
                accountDestination.deposit(amount);
            } catch (NotEnoughBalanceException e) {
                System.out.println("No se ha  podido realizar la transferencia, saldo insuficiente");
            }
        } else {
            System.out.println("No existe una cuenta con iban ");
        }
    }

    private Account findAccount(String iban) {
        Account result = null;
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                result = account;
            }
        }
        return result;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nif, client.nif) && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Arrays.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nif, name, surname);
        result = 31 * result + Arrays.hashCode(accounts);
        return result;
    }
}
