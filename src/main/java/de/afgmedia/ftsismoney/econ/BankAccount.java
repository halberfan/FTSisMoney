package de.afgmedia.ftsismoney.econ;

import de.afgmedia.ftsismoney.main.FTS;
import net.milkbowl.vault.economy.EconomyResponse;

public class BankAccount extends Account {

    private String name;
    private double balance = 0;
    private FTS plugin;

    public BankAccount(String name, FTS fts) {
        this.name = name;
        this.plugin = fts;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public EconomyResponse withdraw(double v) {
        return super.withdraw(v);
    }

    @Override
    public EconomyResponse deposit(double v) {
        return super.deposit(v);
    }

}
