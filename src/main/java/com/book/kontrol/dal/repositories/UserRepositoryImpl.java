package com.book.kontrol.dal.repositories;

import com.book.kontrol.dal.entities.UserEntity;
import com.book.kontrol.dal.infrastructure.DBConnection;
import java.sql.SQLException;

public class UserRepositoryImpl {
    private final String tableName = "user";
    public void create(UserEntity entity) throws SQLException {
        var firstName = String.format("\"%s\"", entity.firstName);
        var lastName = String.format("\"%s\"", entity.lastName);
        var email = entity.email == null
                ? null
                : String.format("\"%s\"", entity.email);
        var phoneNumber = String.format("\"%s\"", entity.phoneNumber);
        var login = String.format("\"%s\"", entity.login);
        var password = String.format("\"%s\"", entity.password);
        var query = String.format("INSERT INTO %s (firstName, lastName, email, phoneNumber, login, password) VALUES (%s, %s, %s, %s, %s, %s)", tableName, firstName, lastName, email, phoneNumber, login, password);
        DBConnection.connection.createStatement().executeUpdate(query);

    }
    public void update(UserEntity entity) throws SQLException {
        var id = entity.id;
        var firstName = String.format("\"%s\"", entity.firstName);
        var lastName = String.format("\"%s\"", entity.lastName);
        var email = entity.email == null
                ? null
                : String.format("\"%s\"", entity.email);
        var phoneNumber = String.format("\"%s\"", entity.phoneNumber);
        var login = String.format("\"%s\"", entity.login);
        var password = String.format("\"%s\"", entity.password);
        var query = String.format("UPDATE %s set firstName = %s, lastName = %s, email = %s, phoneNumber = %s, login = %s, password = %s where id = %s", tableName, firstName, lastName, email, phoneNumber, login, password, id);
        DBConnection.connection.createStatement().executeUpdate(query);
    }
    public void delete(int id) throws SQLException {
        var query = String.format("DELETE FROM %s where id = %s", tableName, id);
        DBConnection.connection.createStatement().executeUpdate(query);
    }

    public UserEntity getByLoginAndPassword(String login, String password) throws SQLException {
        var query = String.format("SELECT * FROM %s WHERE login == \"%s\" and password = \"%s\" limit 1", tableName, login, password);
        var resultSet = DBConnection.connection.createStatement().executeQuery(query);
        while (resultSet.next())
        {
            var user = new UserEntity();
            user.id = resultSet.getInt("id");
            user.firstName = resultSet.getString("firstName");
            user.lastName = resultSet.getString("lastName");
            user.email = resultSet.getString("email");
            user.phoneNumber = resultSet.getString("phoneNumber");
            user.login = resultSet.getString("login");
            user.password = resultSet.getString("password");
        }
        return null;
    }
}
