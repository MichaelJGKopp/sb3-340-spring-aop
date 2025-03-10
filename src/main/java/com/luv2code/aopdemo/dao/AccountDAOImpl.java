package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name="AccountName";

    @Override
    public void addAccount(Account account) {

        System.out.println(getClass() + ": Adding an account");
    }

    @Override
    public String getName() {
        System.out.println(getClass() + ": Getting account name");
        return name;
    }

    @Override
    public List<Account> findAccounts() {
        return List.of(
                new Account("John", "Silver"),
                new Account("Madhu", "Platinum"));
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + ": Setting account name");
        this.name = name;
    }
}
