package com.book.kontrol.dal.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
