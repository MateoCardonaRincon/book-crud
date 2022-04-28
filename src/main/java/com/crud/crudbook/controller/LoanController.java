package com.crud.crudbook.controller;

import com.crud.crudbook.entity.Book;
import com.crud.crudbook.entity.Loan;
import com.crud.crudbook.service.LoanService;
import com.crud.crudbook.service.LoanServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class LoanController {

    @Autowired
    private LoanServiceInterface service;

    @GetMapping("get/loans")
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @GetMapping("get/loans/{userName}")
    public List<Loan> getLoanByUserName(@PathVariable String userName) {
        return service.getLoansByUserName(userName);
    }

    @PostMapping("save/loan")
    public Loan saveLoan(@RequestBody Loan loan) {
        return service.saveLoan(loan);
    }

    @PutMapping("update/loan")
    public Loan updateLoan(@RequestBody Loan loan) {
        return service.updateLoan(loan);
    }

    @DeleteMapping("delete/loan/{id}")
    public Optional<Loan> deleteLoan(@PathVariable Long id) {
        return service.deleteLoan(id);
    }

}