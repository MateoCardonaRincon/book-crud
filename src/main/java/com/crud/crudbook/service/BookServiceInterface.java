package com.crud.crudbook.service;

import com.crud.crudbook.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {

    List<Book> getAllBooks();

    Book saveBook(Book book);

    Book updateBook(Book book);

    Optional<Book> deleteBook(Long id);
}
