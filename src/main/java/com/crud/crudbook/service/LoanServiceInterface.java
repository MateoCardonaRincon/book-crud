package com.crud.crudbook.service;

import com.crud.crudbook.entity.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanServiceInterface {

    List<Loan> getAllLoans();

    List<Loan> getLoansByUserName(String userName);

    Loan saveLoan(Loan loan);

    Loan updateLoan(Loan loan);

    Optional<Loan> deleteLoan(Long id);
}