package org.iesfm.bank;

import org.iesfm.bank.exceptions.NotEnoughBalanceException;

public class Main {
    public static void main(String[] args) {
        Bank bankObject = new Bank("", new Client[0]);
        try {
            bankObject.withdraw("784508", "ES5457214574545", 100);
        } catch (NotEnoughBalanceException e) {
            System.out.println("No se pudo sacar dinero, saldo insuficiente");
        }
    }
}
