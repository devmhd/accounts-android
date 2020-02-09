package me.mehedee.accounts.model;

public class Account {
    public String name;
    public int receivableAmount;

    public Account(String name, int receivableAmount) {
        this.name = name;
        this.receivableAmount = receivableAmount;
    }
}
