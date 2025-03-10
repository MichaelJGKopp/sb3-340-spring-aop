package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account);
    void setName(String name);
    String getName();
    List<Account> findAccounts();
}
