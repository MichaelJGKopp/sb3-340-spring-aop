package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addAccount() throws SQLException {

        System.out.println(getClass() + ": Adding a MEMBERSHIP account");

        throw new SQLException("Exception thrown from MembershipDAOImpl");

//        return false;
    }
}
