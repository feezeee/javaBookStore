package com.book.kontrol.bll.mapper;

import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.book.UpdateBookInput;
import com.book.kontrol.bll.models.input.category.CreateCategoryInput;
import com.book.kontrol.bll.models.input.category.UpdateCategoryInput;
import com.book.kontrol.bll.models.output.book.CategoryModelForGetBookOutput;
import com.book.kontrol.bll.models.output.book.GetBookOutput;
import com.book.kontrol.bll.models.output.category.GetCategoryOutput;
import com.book.kontrol.dal.entities.BookEntity;
import com.book.kontrol.dal.entities.CategoryEntity;

public class Mapper {
    public GetBookOutput toGetBookOutput(BookEntity bookEntity)
    {
        if(bookEntity == null)
        {
            return null;
        }
        var book = new GetBookOutput();
        book.id = bookEntity.id;
        book.name = bookEntity.name;
        book.count = bookEntity.count;
        book.description = bookEntity.description;
        book.price = bookEntity.price;

        return book;
    }
    public BookEntity toBookEntity(CreateBookInput createBookInput)
    {
        if(createBookInput == null)
        {
            return null;
        }
        var book = new BookEntity();
        book.name = createBookInput.name;
        book.count = createBookInput.count;
        book.description = createBookInput.description;
        book.price = createBookInput.price;

        return book;
    }
    public BookEntity toBookEntity(UpdateBookInput updateBookInput)
    {
        if(updateBookInput == null)
        {
            return null;
        }
        var book = new BookEntity();
        book.id = updateBookInput.id;
        book.name = updateBookInput.name;
        book.count = updateBookInput.count;
        book.description = updateBookInput.description;
        book.price = updateBookInput.price;

        return book;
    }

    public GetCategoryOutput toGetCategoryOutput(CategoryEntity categoryEntity)
    {
        if(categoryEntity == null)
        {
            return null;
        }
        var categoryOutput = new GetCategoryOutput();
        categoryOutput.id = categoryEntity.id;
        categoryOutput.name = categoryEntity.name;

        return categoryOutput;
    }
    public CategoryEntity toCategoryEntity(CreateCategoryInput createCategoryInput)
    {
        if(createCategoryInput == null)
        {
            return null;
        }
        var categoryEntity = new CategoryEntity();
        categoryEntity.name = createCategoryInput.name;

        return categoryEntity;
    }
    public CategoryEntity toCategoryEntity(UpdateCategoryInput updateCategoryInput)
    {
        if(updateCategoryInput == null)
        {
            return null;
        }
        var categoryEntity = new CategoryEntity();
        categoryEntity.id = updateCategoryInput.id;
        categoryEntity.name = updateCategoryInput.name;

        return categoryEntity;
    }

    public CategoryModelForGetBookOutput toCategoryModelForGetBookOutput(CategoryEntity categoryEntity){
        if(categoryEntity == null){
            return null;
        }
        var category = new CategoryModelForGetBookOutput();
        category.id = categoryEntity.id;
        category.name = categoryEntity.name;
        return category;
    }
}
