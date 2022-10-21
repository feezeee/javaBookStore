package com.book.kontrol.bll.services.abstractions;

import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.book.UpdateBookInput;
import com.book.kontrol.bll.models.input.category.CreateCategoryInput;
import com.book.kontrol.bll.models.input.category.UpdateCategoryInput;
import com.book.kontrol.bll.models.output.book.GetBookOutput;
import com.book.kontrol.bll.models.output.category.GetCategoryOutput;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryService {
    GetCategoryOutput create(CreateCategoryInput entity) throws SQLException;
    GetCategoryOutput update(UpdateCategoryInput entity) throws SQLException;
    void delete(int id) throws SQLException;
    ArrayList<GetCategoryOutput> getAll() throws SQLException;
    GetCategoryOutput getById(int id) throws SQLException;
}
