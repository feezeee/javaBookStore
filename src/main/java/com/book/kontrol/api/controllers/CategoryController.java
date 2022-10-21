package com.book.kontrol.api.controllers;

import com.book.kontrol.api.mapper.Mapper;
import com.book.kontrol.api.request.book_controller.PostBookRequest;
import com.book.kontrol.api.request.category_controller.PostCategoryRequest;
import com.book.kontrol.api.request.category_controller.PutCategoryRequest;
import com.book.kontrol.api.response.book_controller.GetBookResponse;
import com.book.kontrol.api.response.category_controller.GetCategoryResponse;
import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.category.CreateCategoryInput;
import com.book.kontrol.bll.services.abstractions.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<GetCategoryResponse>> getCategories()
    {
        try{
            var mapper = new Mapper();
            var res = categoryService.getAll();
            var newRes = new ArrayList<GetCategoryResponse>(0);
            res.forEach(it-> newRes.add(mapper.toGetCategoryResponse(it)));

            return ResponseEntity.ok(newRes);
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryResponse> getCategories(@PathVariable int id)
    {
        try{
            var mapper = new Mapper();
            var res = categoryService.getById(id);
            var getCategoryResponse = mapper.toGetCategoryResponse(res);
            return ResponseEntity.ok(getCategoryResponse);
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<GetCategoryResponse> postCategory(@RequestBody PostCategoryRequest entity)
    {
        try{
            var mapper = new Mapper();
            var createCategoryInput = mapper.toCreateCategoryInput(entity);
            var result = categoryService.create(createCategoryInput);
            var mappedResult = mapper.toGetCategoryResponse(result);
            return new ResponseEntity(mappedResult, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity putCategory(@RequestBody PutCategoryRequest entity)
    {
        try{
            var mapper = new Mapper();
            var updateCategoryInput = mapper.toUpdateCategoryInput(entity);
            categoryService.update(updateCategoryInput);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }
    @DeleteMapping
    public ResponseEntity deleteCategory(@RequestParam int id)
    {
        try{
            var isExist = categoryService.getById(id) == null
                    ? false
                    : true;
            if(!isExist)
            {
                return badRequest().build();
            }
            categoryService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }
}
