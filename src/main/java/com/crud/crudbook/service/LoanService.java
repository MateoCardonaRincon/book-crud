package com.crud.crudbook.service;

import com.crud.crudbook.entity.Loan;
import com.crud.crudbook.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService implements LoanServiceInterface {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan saveLoan(Loan loan) {
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
        Optional<Loan> loanExist = loanRepository.findById(id);
        if(loanExist.isPresent()){
            loanRepository.deleteById(id);
            return loanExist;
        }
        return loanExist;
    }
}
