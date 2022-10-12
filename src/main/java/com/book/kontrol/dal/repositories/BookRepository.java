package com.book.kontrol.dal.repositories;

import com.book.kontrol.bll.abstractions.repositories.IBookRepository;
import com.book.kontrol.bll.entities.BookEntity;
import com.book.kontrol.dal.infrastructure.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class BookRepository implements IBookRepository {
    public void create(BookEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("INSERT INTO book (name, description) VALUES (\"%s\", \"%s\")", entity.name, entity.description));
    }
    public void update(BookEntity entity) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("UPDATE book set name = \"%s\", description = \"%s\" where id = %s", entity.name, entity.description, entity.id));
    }
    public void delete(int id) throws SQLException {
        DBConnection.statement.executeUpdate(String.format("DELETE FROM book where id = %s", id));
    }
    public ArrayList<BookEntity> getAll() throws SQLException {
        var resultSet = DBConnection.statement.executeQuery(String.format("SELECT * FROM book"));
        var result = new ArrayList<BookEntity>(0);
        while (resultSet.next())
        {
            var book = new BookEntity();
            book.id = resultSet.getInt("id");
            book.name = resultSet.getString("name");
            book.description = resultSet.getString("description");
            result.add(book);
        }
        return result;
    }
}
