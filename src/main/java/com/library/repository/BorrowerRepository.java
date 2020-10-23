package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.library.models.Borrower;

@Repository
@Component
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
	
	

}
