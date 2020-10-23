package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.models.Book;
import com.library.models.Borrower;
import com.library.models.LoanRecord;

@Repository
public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long> {
	
	List<LoanRecord> findByBook(Book b1);
	List<LoanRecord> findByBorrower(Borrower b1);
	
}
