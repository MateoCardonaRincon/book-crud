package com.crud.crudbook.service;

import com.crud.crudbook.entity.Loan;
import com.crud.crudbook.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class LoanService implements LoanServiceInterface {

    @Autowired
    private LoanRepository loanRepository;

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
        List<Loan> userLoans = getLoansByUserName(loan.getUserName());
        Stream<Loan> activeLoans = userLoans.stream().filter(l -> !l.getIsReturned());
        if (activeLoans.count() > 0) {
            return null;
        }
        return loanRepository.save(loan);
    }

    @Override
    public Loan updateLoan(Loan loan) {
        Optional<Loan> loanExist = loanRepository.findById(loan.getId());
        if (loanExist.isEmpty()) {
            return null;
        }
        return loanRepository.save(loan);
    }

    @Override
    public Optional<Loan> deleteLoan(Long id) {
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isPresent()) {
            loanRepository.deleteById(id);
            return existingLoan;
        }
        return existingLoan;
    }
}
