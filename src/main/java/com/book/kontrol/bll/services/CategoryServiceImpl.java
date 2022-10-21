package com.book.kontrol.bll.services;

import com.book.kontrol.bll.mapper.Mapper;
import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.book.UpdateBookInput;
import com.book.kontrol.bll.models.input.category.CreateCategoryInput;
import com.book.kontrol.bll.models.input.category.UpdateCategoryInput;
import com.book.kontrol.bll.models.output.book.GetBookOutput;
import com.book.kontrol.bll.models.output.category.GetCategoryOutput;
import com.book.kontrol.bll.services.abstractions.CategoryService;
import com.book.kontrol.dal.abstractions.CategoryRepository;
import com.book.kontrol.dal.entities.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GetCategoryOutput create(CreateCategoryInput entity) throws SQLException {
        var mapper = new Mapper();
        var categoryEntity = mapper.toCategoryEntity(entity);
        var result = categoryRepository.create(categoryEntity);
        return mapper.toGetCategoryOutput(result);
    }

    @Override
    public GetCategoryOutput update(UpdateCategoryInput entity) throws SQLException {
        var mapper = new Mapper();
        var categoryEntity = mapper.toCategoryEntity(entity);
        var result = categoryRepository.update(categoryEntity);
        return mapper.toGetCategoryOutput(result);
    }

    @Override
    public void delete(int id) throws SQLException {
        categoryRepository.delete(id);
    }

    @Override
    public ArrayList<GetCategoryOutput> getAll() throws SQLException {
        var mapper = new Mapper();
        var categoryOutputs = new ArrayList<GetCategoryOutput>(0);
        categoryRepository.getAll().forEach(it -> categoryOutputs.add(mapper.toGetCategoryOutput(it)));
        return categoryOutputs;
    }

    @Override
    public GetCategoryOutput getById(int id) throws SQLException {
        var mapper = new Mapper();
        var res = categoryRepository.getById(id);
        var getCategoryOutput = mapper.toGetCategoryOutput(res);
        return getCategoryOutput;
    }
}
