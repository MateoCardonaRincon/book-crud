package com.crud.crudbook.service;

import com.crud.crudbook.entity.Book;
import com.crud.crudbook.entity.Loan;
import com.crud.crudbook.repository.BookRepository;
import com.crud.crudbook.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService implements LoanServiceInterface {


    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getLoansByUserName(String userName) {
        return loanRepository.getLoansByUserName(userName);
    }

    @Override
    public Loan saveLoan(Loan loan) {
        List<Loan> userActiveLoans = getLoansByUserName(loan.getUserName());
        Optional<Book> existingBook = bookRepository.findById(loan.getFkBook());
        if (existingBook.isPresent() && userActiveLoans.size() < 3) {
            return existingBook.get().getAvailable() ? loanRepository.save(loan) : null;
        }
        return null;
    }

    @Override
    public Loan updateLoan(Loan loan) {
        Optional<Loan> loanExists = loanRepository.findById(loan.getId());
        return loanExists.isPresent() ? null : loanRepository.save(loan);
    }

    @Override
    public Optional<Loan> deleteLoan(Long id) {
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isPresent()) {
            loanRepository.deleteById(id);
            return existingLoan;
        }
        return Optional.empty();
    }
}
