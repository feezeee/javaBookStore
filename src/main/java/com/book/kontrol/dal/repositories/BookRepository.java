package com.book.kontrol.dal.repositories;

import com.book.kontrol.bll.abstractions.repositories.IBookRepository;
import com.book.kontrol.bll.entities.BookEntity;
import com.book.kontrol.dal.infrastructure.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class BookRepository implements IBookRepository {
    public void create(BookEntity entity) throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery(String.format("INSERT INTO book ('name', 'description') VALUES ('%s', '%s') ", entity.name, entity.description));
    }
    public void update(BookEntity entity) throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery(String.format("UPDATE book set name = '%s', description = '%s' where id = %i", entity.name, entity.description, entity.id));
    }
    public void delete(int id) throws SQLException {
        ResultSet resultSet = DBConnection.statement.executeQuery(String.format("DELETE FROM book where id = %i", id));
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
