package com.crud.crudbook.controller;

import com.crud.crudbook.entity.Book;
import com.crud.crudbook.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class BookController {

    @Autowired
    private BookServiceInterface service;

    @GetMapping("get/books")
    public List<Book> getAllBooks(){
            return service.getAllBooks();
    }

    @GetMapping("get/books/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title){
        return service.getBooksByTitle(title);
    }

    @PostMapping("save/book")
    public Book saveBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @PutMapping("update/book")
    public Book updateBook(@RequestBody Book book){
        return service.updateBook(book);
    }

    @DeleteMapping("delete/book/{id}")
    public Optional<Book> deleteBook(@PathVariable Long id){
        return service.deleteBook(id);
    }

}
