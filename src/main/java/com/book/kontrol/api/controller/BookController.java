package com.book.kontrol.api.controller;

import com.book.kontrol.bll.abstractions.services.IBookService;
import com.book.kontrol.bll.entities.BookEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("api/books")
public class BookController {

    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity getBooks()
    {
        try{
            var resStr = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(bookService.getAll());
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PostMapping
    public ResponseEntity postBook(@RequestBody BookEntity entity)
    {
        try{
            bookService.create(entity);
            return ResponseEntity.ok().body("Все ок!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PutMapping
    public ResponseEntity putBook(@RequestBody BookEntity entity)
    {
        try{
            bookService.update(entity);
            return ResponseEntity.ok().body("Все ок!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestParam int id)
    {
        try{
            bookService.delete(id);
            return ResponseEntity.ok().body("Все ок!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }
}
