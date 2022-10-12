package com.book.kontrol.bll.services;

import com.book.kontrol.bll.abstractions.repositories.IBookRepository;
import com.book.kontrol.bll.abstractions.services.IBookService;
import com.book.kontrol.bll.entities.BookEntity;
import com.book.kontrol.dal.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class BookService implements IBookService {

    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void create(BookEntity entity) throws SQLException {
        bookRepository.create(entity);
    }
    public void update(BookEntity entity) throws SQLException {
        bookRepository.update(entity);
    }
    public void delete(int id) throws SQLException {
        bookRepository.delete(id);
    }
    public ArrayList<BookEntity> getAll() throws SQLException {
       return bookRepository.getAll();
    }
}
