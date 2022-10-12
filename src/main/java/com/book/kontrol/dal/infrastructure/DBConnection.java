package com.book.kontrol.dal.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static Statement statement;
    static {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabookstore", "root", "admin");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
