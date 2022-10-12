package com.book.kontrol.di;

import com.book.kontrol.bll.abstractions.repositories.IBookRepository;
import com.book.kontrol.bll.abstractions.services.IBookService;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.javalang.injection")
public class Config {
    public IBookRepository bookRepository;
    public IBookService bookService;
}
