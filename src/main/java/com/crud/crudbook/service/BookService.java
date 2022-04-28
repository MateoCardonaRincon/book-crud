package com.crud.crudbook.service;

import com.crud.crudbook.entity.Book;
import com.crud.crudbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> bookExist = bookRepository.findById(book.getId());
        if(bookExist.isEmpty()){
            return null;
        }
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> deleteBook(Long id) {
        Optional<Book> bookExist = bookRepository.findById(id);
        if(bookExist.isPresent()){
            bookRepository.deleteById(id);
            return bookExist;
        }
        return bookExist;
    }
}
