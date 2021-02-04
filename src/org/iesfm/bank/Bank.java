package org.iesfm.bank;

import org.iesfm.bank.exceptions.NotEnoughBalanceException;

import java.util.Arrays;
import java.util.Objects;

public class Bank implements IBank {
    private String name;
    private Client[] clients;

    public Bank(String name, Client[] clients) {
        this.name = name;
        this.clients = clients;
    }

    @Override
    public void withdraw(String nif, String iban, double amount) throws NotEnoughBalanceException  {
        Client client = findClient(nif);
        if(client != null) {
            client.withdraw(iban, amount);
        } else {
            System.out.println("No existe el cliente con nif " + nif);
        }
    }

    @Override
    public void transfer(String nif, String ibanOrigin, String ibanDestination, double amount) {
        Client client = findClient(nif);
        if(client != null) {
            client.transfer(ibanOrigin, ibanDestination, amount);
        } else {
            System.out.println("No existe el cliente con nif " + nif);
        }
    }

    private Client findClient(String nif) {
        Client result = null;
        for(Client client: clients) {
            if(client.getNif().equals(nif)) {
                result = client;
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Arrays.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(clients);
        return result;
    }
}
