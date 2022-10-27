package com.book.kontrol.dal.repositories;

import com.book.kontrol.dal.abstractions.BookRepository;
import com.book.kontrol.dal.entities.BookCategoryEntity;
import com.book.kontrol.dal.entities.BookEntity;
import com.book.kontrol.dal.entities.CategoryEntity;
import com.book.kontrol.dal.infrastructure.DBConnection;
import com.sun.source.tree.LambdaExpressionTree;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public BookEntity create(BookEntity entity) throws SQLException {
        var query = "insert into book (name, description, price, count) values (?, ?, ?, ?)";
        int primkey = 0;
        String collumnNames[] = new String[] {"id"};
        var prepareStatement = DBConnection.connection.prepareStatement(query, collumnNames);
        prepareStatement.setString(1, entity.name);
        prepareStatement.setString(2, entity.description);
        prepareStatement.setDouble(3, entity.price);
        prepareStatement.setInt(4, entity.count);
        if(prepareStatement.executeUpdate() > 0)
        {
            var generatedKeys = prepareStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                primkey = generatedKeys.getInt(1);
            }
        }
        return this.getById(primkey);
    }
    @Override
    public BookEntity update(BookEntity entity) throws SQLException {
        var query = "update book set name = ?, description = ?, price = ?, count = ? where id = ?";
        var prepareStatement = DBConnection.connection.prepareStatement(query);
        prepareStatement.setString(1, entity.name);
        prepareStatement.setString(2, entity.description);
        prepareStatement.setDouble(3, entity.price);
        prepareStatement.setInt(4, entity.count);
        prepareStatement.setInt(5, entity.id);
        prepareStatement.executeUpdate();
        return this.getById(entity.id);
    }
    @Override
    public void delete(int id) throws SQLException {
        var query = "delete from book where id = ?";
        var prepareStatement = DBConnection.connection.prepareStatement(query);
        prepareStatement.setInt(1, id);
        prepareStatement.executeUpdate();
    }
    @Override
    public ArrayList<BookEntity> getAll() throws SQLException {
        var query = "select * from book";
        var prepareStatement = DBConnection.connection.prepareStatement(query);
        var resultSet = prepareStatement.executeQuery();
        var result = new ArrayList<BookEntity>(0);
        while (resultSet.next())
        {
            var book = new BookEntity();
            book.id = resultSet.getInt(1);
            book.name = resultSet.getString(2);
            book.description = resultSet.getString(3);
            book.price = resultSet.getDouble(4);
            book.count = resultSet.getInt(5);
            result.add(book);
        }
        return result;
    }
    @Override
    public BookEntity getById(int id) throws SQLException
    {
        var query = "select * from book where id = ? limit 1";
        var prepareStatement = DBConnection.connection.prepareStatement(query);
        prepareStatement.setInt(1, id);
        var resultSet = prepareStatement.executeQuery();
        while (resultSet.next())
        {
            var book = new BookEntity();
            book.id = resultSet.getInt("id");
            book.name = resultSet.getString("name");
            book.description = resultSet.getString("description");
            book.price = resultSet.getDouble("price");
            book.count = resultSet.getInt("count");
            return book;
        }
        return null;
    }
}
