package com.lab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonConnection {

    private String url;
    private String user;
    private String password;

    public CommonConnection(String url, String user, String password){

        this.url = url;
        this.user = user;
        this.password = password;

    }
    public CommonConnection(){  /* конструктор со значениями по умолчанию*/
        this("jdbc:postgresql://localhost:5433/tourAgency","postgres","anna5kanna");
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the NevskyTourOperator server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
