package com.book.kontrol.bll.abstractions.services;

import com.book.kontrol.bll.entities.BookEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBookService {
    public void create(BookEntity entity) throws SQLException;
    public void update(BookEntity entity) throws SQLException;
    public void delete(int id) throws SQLException;
    public ArrayList<BookEntity> getAll() throws SQLException;
}
