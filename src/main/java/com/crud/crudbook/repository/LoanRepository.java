package com.crud.crudbook.repository;

import com.crud.crudbook.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository  extends JpaRepository<Loan, Long> {
}
