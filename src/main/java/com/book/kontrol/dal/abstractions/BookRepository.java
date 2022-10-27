package com.book.kontrol.dal.abstractions;

import com.book.kontrol.dal.entities.BookEntity;
import com.sun.source.tree.LambdaExpressionTree;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookRepository {
    BookEntity create(BookEntity entity) throws SQLException;
    BookEntity update(BookEntity entity) throws SQLException;
    void delete(int id) throws SQLException;
    ArrayList<BookEntity> getAll() throws SQLException;
    BookEntity getById(int id) throws SQLException;

}
