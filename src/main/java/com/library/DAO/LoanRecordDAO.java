package com.library.DAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.models.Book;
import com.library.models.Borrower;
import com.library.models.LoanRecord;
import com.library.repository.BorrowerRepository;
import com.library.repository.LoanRecordRepository;

@Component
public class LoanRecordDAO {
	
	@Autowired
	LoanRecordRepository loanRecordRepository;
	
	@Autowired
	BorrowerRepository borrowerRepository;
	
	
	public void saveOrUpdate(LoanRecord loanRecord)   
	{  
		loanRecordRepository.save(loanRecord);  
	}  
	
	
	public Set<Borrower> getLoanReCordByBook(Book b)   
	{   
		Set<Borrower> bSet = new HashSet<Borrower>();
		loanRecordRepository.findByBook(b).forEach(loanRecord -> bSet.add(loanRecord.getBorrower())); 
		return bSet;
	} 
	
	public Set<Book> getLoanReCordByBorr(Borrower b)   
	{   
		Set<Book> bSet = new HashSet<Book>();
		loanRecordRepository.findByBorrower(b).forEach(loanRecord -> bSet.add(loanRecord.getBook())); 
		return bSet;
	} 

}
