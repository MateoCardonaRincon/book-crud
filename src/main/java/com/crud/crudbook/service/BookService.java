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
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.getBooksByTitle(title);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> existingBook = bookRepository.findById(book.getId());
        if(existingBook.isPresent()){
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public Optional<Book> deleteBook(Long id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()){
            bookRepository.deleteById(id);
            return existingBook;
        }
        return Optional.empty();
    }
}
