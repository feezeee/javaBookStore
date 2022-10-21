package com.book.kontrol.bll.services.abstractions;

import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.book.UpdateBookInput;
import com.book.kontrol.bll.models.output.book.GetBookOutput;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookService {
    GetBookOutput create(CreateBookInput entity) throws SQLException;
    GetBookOutput update(UpdateBookInput entity) throws SQLException;
    void delete(int id) throws SQLException;
    ArrayList<GetBookOutput> getAll(boolean includeCategories) throws SQLException;
    GetBookOutput getById(int id) throws SQLException;
}
