package com.book.kontrol.dal.repositories;

import com.book.kontrol.dal.abstractions.CategoryRepository;
import com.book.kontrol.dal.entities.BookEntity;
import com.book.kontrol.dal.entities.CategoryEntity;
import com.book.kontrol.dal.entities.UserEntity;
import com.book.kontrol.dal.infrastructure.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    String tableName = "category";
    @Override
    public CategoryEntity create(CategoryEntity entity) throws SQLException {
        var query = "insert into category (name) VALUES(?)";
        int primkey = 0;
        String collumnNames[] = new String[] {"id"};
        var pstmt = DBConnection.connection.prepareStatement(query, collumnNames);
        pstmt.setString(1, entity.name);
        if(pstmt.executeUpdate() > 0)
        {
            var generatedKeys = pstmt.getGeneratedKeys();
            if(generatedKeys.next()){
                primkey = generatedKeys.getInt(1);
            }
        }
        return this.getById(primkey);
    }

    @Override
    public CategoryEntity update(CategoryEntity entity) throws SQLException {
        var query = "update category set name = ? where id = ?";

        var pstmt = DBConnection.connection.prepareStatement(query);
        pstmt.setString(1, entity.name);
        pstmt.setInt(2, entity.id);
        pstmt.executeUpdate();

        return this.getById(entity.id);
    }

    @Override
    public void delete(int id) throws SQLException {
        var query = "delete from category where id = ?";
        var pstmt = DBConnection.connection.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws SQLException {
        var query = "select * from category";
        var statement = DBConnection.connection.createStatement();
        var resultSet = statement.executeQuery(query);
        var result = new ArrayList<CategoryEntity>(0);
        while (resultSet.next())
        {
            var category = new CategoryEntity();
            category.id = resultSet.getInt("id");
            category.name = resultSet.getString("name");
            result.add(category);
        }
        return result;
    }

    @Override
    public CategoryEntity getById(int id) throws SQLException {
        var query = "select * from category where id = ? limit 1";
        var prepareStatement = DBConnection.connection.prepareStatement(query);
        prepareStatement.setInt(1, id);
        var resultSet = prepareStatement.executeQuery();
        while (resultSet.next())
        {
            var category = new CategoryEntity();
            category.id = resultSet.getInt("id");
            category.name = resultSet.getString("name");
            return category;
        }
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getByBookId(int bookId) throws SQLException {
        var query = "select cat.id, cat.name from category as cat\n" +
                "left join book_has_category as bhc on cat.id = bhc.category_id\n" +
                "where bhc.book_id = ?";
        var prepareStatement = DBConnection.connection.prepareStatement(query);
        prepareStatement.setInt(1, bookId);
        var resultSet = prepareStatement.executeQuery();
        var categories = new ArrayList<CategoryEntity>(0);
        while (resultSet.next())
        {
            var category = new CategoryEntity();
            category.id = resultSet.getInt(1);
            category.name = resultSet.getString(2);
            categories.add(category);
        }
        return categories;
    }
}
