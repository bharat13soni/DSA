package com.practice;

import java.sql.SQLException;

class Parent {

    // defining the method
    void msg() throws SQLException {
        System.out.println("parent method");
    }
}

public class TestExceptionChild extends Parent {

    // overriding the method in child class
    // gives compile time error
    void msg() throws NullPointerException {
        System.out.println("TestExceptionChild");
    }

    public static void main(String[] args) {
        Parent p = new TestExceptionChild();
        try {
            p.msg();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}    
