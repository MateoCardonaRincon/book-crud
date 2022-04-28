package com.crud.crudbook.repository;

import com.crud.crudbook.entity.Book;
import com.crud.crudbook.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    public List<Book> getBooksByTitle(@Param("title") String userName);

}
