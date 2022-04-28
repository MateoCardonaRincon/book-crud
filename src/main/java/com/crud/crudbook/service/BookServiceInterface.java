package com.crud.crudbook.service;

import com.crud.crudbook.entity.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {

    List<Book> getAllBooks();

    List<Book> getBooksByTitle(@Param("title") String title);

    Book saveBook(Book book);

    Book updateBook(Book book);

    Optional<Book> deleteBook(Long id);
}
