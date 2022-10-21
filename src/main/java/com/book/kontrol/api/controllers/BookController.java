package com.book.kontrol.api.controllers;

import com.book.kontrol.api.mapper.Mapper;
import com.book.kontrol.api.request.book_controller.PostBookRequest;
import com.book.kontrol.api.request.book_controller.PutBookRequest;
import com.book.kontrol.api.response.book_controller.GetBookResponse;
import com.book.kontrol.bll.models.input.book.CreateBookInput;
import com.book.kontrol.bll.models.input.book.UpdateBookInput;
import com.book.kontrol.bll.models.output.book.GetBookOutput;
import com.book.kontrol.bll.services.abstractions.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("api/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public ResponseEntity<List<GetBookResponse>> getBooks(@RequestParam(name = "includeCategories", required = false) boolean includeCategories)
    {
        try{
            var mapper = new Mapper();
            var res = bookService.getAll(includeCategories);
            var newRes = new ArrayList<GetBookResponse>(0);
            res.forEach(it-> newRes.add(mapper.toGetBookResponse(it)));
            return ResponseEntity.ok(newRes);
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBookResponse> getBookById(@PathVariable int id)
    {
        try{
            var mapper = new Mapper();
            var res = bookService.getById(id);
            var mappedRes = mapper.toGetBookResponse(res);
            return ResponseEntity.ok(mappedRes);
        }
        catch (Exception e)
        {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<GetBookResponse> postBook(@RequestBody PostBookRequest entity)
    {
        try{
            var mapper = new Mapper();
            var book = new CreateBookInput();
            book.name = entity.name;
            book.description = entity.description;
            var result = bookService.create(book);
            var mappedResult = mapper.toGetBookResponse(result);
            return new ResponseEntity<GetBookResponse>(mappedResult, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity putBook(@RequestBody PutBookRequest entity)
    {
        try{
            var book = new UpdateBookInput();
            book.id = entity.id;
            book.name = entity.name;
            book.description = entity.description;
            bookService.update(book);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestParam int id)
    {
        try{
            var isExist = bookService.getById(id) == null
                    ? false
                    : true;
            if(!isExist)
            {
                return badRequest().build();
            }
            bookService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            return internalServerError().build();
        }
    }
}
