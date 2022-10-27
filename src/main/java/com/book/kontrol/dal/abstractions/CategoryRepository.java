package com.book.kontrol.dal.abstractions;

import com.book.kontrol.bll.models.input.category.CreateCategoryInput;
import com.book.kontrol.bll.models.input.category.UpdateCategoryInput;
import com.book.kontrol.bll.models.output.category.GetCategoryOutput;
import com.book.kontrol.dal.entities.BookEntity;
import com.book.kontrol.dal.entities.CategoryEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoryRepository {
    CategoryEntity create(CategoryEntity entity) throws SQLException;
    CategoryEntity update(CategoryEntity entity) throws SQLException;
    void delete(int id) throws SQLException;
    ArrayList<CategoryEntity> getAll() throws SQLException;
    CategoryEntity getById(int id) throws SQLException;
    ArrayList<CategoryEntity> getByBookId(int bookId) throws SQLException;
}
