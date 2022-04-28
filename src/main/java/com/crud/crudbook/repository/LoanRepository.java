package com.crud.crudbook.repository;

import com.crud.crudbook.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.userName = :userName")
    public List<Loan> getLoansByUserName(@Param("userName") String userName);

}
