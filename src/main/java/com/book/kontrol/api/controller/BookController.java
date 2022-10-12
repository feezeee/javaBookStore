package com.book.kontrol.api.controller;

import com.book.kontrol.api.request.book_controller.PostBookRequest;
import com.book.kontrol.api.request.book_controller.PutBookRequest;
import com.book.kontrol.api.response.book_controller.GetBookResponse;
import com.book.kontrol.bll.abstractions.services.IBookService;
import com.book.kontrol.bll.entities.BookEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
            var res = bookService.getAll();
            var newRes = new ArrayList<GetBookResponse>(0);
            for (var i = 0; i<res.size(); i++)
            {
                var book = new GetBookResponse();
                book.id = res.get(i).id;
                book.name = res.get(i).name;
                book.description = res.get(i).description;
                newRes.add(book);
            }
            var resStr = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(newRes);
            return ResponseEntity.ok(resStr);
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PostMapping
    public ResponseEntity postBook(@RequestBody PostBookRequest entity)
    {
        try{
            var book = new BookEntity();
            book.name = entity.name;
            book.description = entity.description;
            bookService.create(book);
            return ResponseEntity.ok().body("Все ок!");
        }
        catch (Exception e)
        {
            return internalServerError().body("Some problem with server!");
        }
    }

    @PutMapping
    public ResponseEntity putBook(@RequestBody PutBookRequest entity)
    {
        try{
            var book = new BookEntity();
            book.id = entity.id;
            book.name = entity.name;
            book.description = entity.description;
            bookService.update(book);
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
