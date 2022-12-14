package com.book.kontrol.bll.services;

import com.book.kontrol.bll.mapper.Mapper;
import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.book.UpdateBookInput;
import com.book.kontrol.bll.models.output.book.CategoryModelForGetBookOutput;
import com.book.kontrol.bll.models.output.book.GetBookOutput;
import com.book.kontrol.bll.services.abstractions.BookService;
import com.book.kontrol.dal.abstractions.BookRepository;
import com.book.kontrol.dal.abstractions.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public GetBookOutput create(CreateBookInput entity) throws SQLException {
        var mapper = new Mapper();
        var book = mapper.toBookEntity(entity);
        var result = bookRepository.create(book);
        return mapper.toGetBookOutput(result);
    }
    public GetBookOutput update(UpdateBookInput entity) throws SQLException {
        var mapper = new Mapper();
        var book = mapper.toBookEntity(entity);
        var result = bookRepository.update(book);
        return mapper.toGetBookOutput(result);
    }
    public void delete(int id) throws SQLException {
        bookRepository.delete(id);
    }
    public ArrayList<GetBookOutput> getAll(boolean includeCategories) throws SQLException {
        var mapper = new Mapper();
        var books = new ArrayList<GetBookOutput>(0);
        var booksResult = bookRepository.getAll();
        for (int i = 0; i < booksResult.size(); i++)
        {
            var newBook = mapper.toGetBookOutput(booksResult.get(i));
            if(includeCategories == true)
            {
                newBook.categories = new ArrayList<CategoryModelForGetBookOutput>(0);
                var existCategories = categoryRepository.getByBookId(newBook.id);
                existCategories.forEach(it->newBook.categories.add(mapper.toCategoryModelForGetBookOutput(it)));
            }
            books.add(newBook);
        }
        return books;
    }
    public GetBookOutput getById(int id) throws SQLException{
        var mapper = new Mapper();
        var book = bookRepository.getById(id);
        return mapper.toGetBookOutput(book);
    }
}
