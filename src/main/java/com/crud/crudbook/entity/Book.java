package com.crud.crudbook.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Book")
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;

    private String author;

    private Integer numberPages;

    private Boolean available;
}
