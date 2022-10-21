package com.book.kontrol.di;

import com.book.kontrol.bll.services.abstractions.BookService;
import com.book.kontrol.bll.services.abstractions.CategoryService;
import com.book.kontrol.dal.abstractions.BookRepository;
import com.book.kontrol.dal.abstractions.CategoryRepository;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.javalang.injection")
public class Config {
    public BookRepository bookRepository;
    public BookService bookService;


    public CategoryRepository categoryRepository;
    public CategoryService categoryService;
}
