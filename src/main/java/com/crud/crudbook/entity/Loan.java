package com.crud.crudbook.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Loan")
@Table(name = "loan")
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private Date loanDate;

    private Boolean isReturned;
}