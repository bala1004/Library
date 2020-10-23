package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.library.models.Book;
import com.library.models.Borrower;

@Repository
@Component
public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByBorrower(Borrower b1);
}
