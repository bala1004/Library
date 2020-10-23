package com.library.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.DAO.BookDAO;
import com.library.DAO.BorrowerDAO;
import com.library.DAO.LoanRecordDAO;
import com.library.models.Book;
import com.library.models.Borrower;
import com.library.models.LoanRecord;
import com.library.repository.BookRepository;
import com.library.repository.BorrowerRepository;

@RestController
@Component
@RequestMapping("/api/v1/")
public class LibraryController {
	
	@Autowired  
	private BookDAO booksDAO;  
	
	@Autowired  
	private BorrowerDAO borrowerDAO;  
	
	@Autowired
	private LoanRecordDAO loanRecordDAO;
	
	@PostMapping("/borrower")
	public String createBorrower(@Validated @RequestBody Borrower borrower) {
		borrowerDAO.saveOrUpdate(borrower);
		return ("{'Success':'borrower saved to database'}");
	}
	
	@RequestMapping("/borrowerById/{id}")
	public Borrower getBorrowerById(@PathVariable("id") long id) {
		return borrowerDAO.getBorrowerById(id);
	}
	
	@RequestMapping("/getBorrowers")
	public List<Borrower> getBorrowers() {
		System.out.println("teststt");
		return borrowerDAO.getAllBorrowers();
	}
	
	@RequestMapping("/getPrevBooks/{id}")
	public Set<Book> getPrevBooks(@PathVariable("id") long id) {
		Borrower b1 = borrowerDAO.getBorrowerById(id);
		Set<Book> bookSet= loanRecordDAO.getLoanReCordByBorr(b1); 
		Book currentBook  = booksDAO.getBookByBorrower(b1);
		bookSet.remove(currentBook);
		return bookSet;
	}
	
	@RequestMapping("/getPrevBorrowers/{id}")
	public Set<Borrower> getPrevBorrowers(@PathVariable("id") long id) {
		Book b1 = booksDAO.getBookById(id);
		Set<Borrower> borrowerSet = loanRecordDAO.getLoanReCordByBook(b1);
		if (b1.getBorrower() != null){
			borrowerSet.remove(b1.getBorrower());
		}
		return borrowerSet;
	}
	
	@PostMapping("/book")
	public String createBook(@Validated @RequestBody Book book) {
		booksDAO.saveOrUpdate(book);
		return ("{'Success':'Book saved to database'}");
	}
	
	@PutMapping("/updateBook")
	public String updateBook(@Validated @RequestBody Book book) {
		booksDAO.saveOrUpdate(book);
		return ("{'Success':'Book updated on database'}");
	}
	
	@RequestMapping("/bookbyId/{id}")
	public Book getBookById(@PathVariable("id") long id) {
		return booksDAO.getBookById(id);
	}
	
	@RequestMapping("/getBooks")
	public List<Book> getBooks() {
		return booksDAO.getAllBooks();
	}
	
	@PostMapping("/loanRecord")
	public String createLoanRecord(@Validated @RequestBody LoanRecord loanRecord) {
		Book b1 = (Book)(loanRecord.getBook());
		Borrower br1 = (Borrower)(loanRecord.getBorrower());
		Book bookData = booksDAO.getBookById(b1.getId());
		Borrower barrData = borrowerDAO.getBorrowerById(br1.getId());
		if(barrData!=null && bookData!=null ) {
			if (bookData.getBorrower() == null){
				if (barrData!=null && barrData.getBorrowLimit() < 5) {
					System.out.println("inside if");
					loanRecordDAO.saveOrUpdate(loanRecord);
					barrData.setBorrowLimit(barrData.getBorrowLimit()+1);
					borrowerDAO.saveOrUpdate(barrData);
					bookData.setBorrower(barrData);
					booksDAO.saveOrUpdate(bookData);
					return ("{'Success':'loanRecord saved to database'}");
				}else {
					return ("{'Fail':'Borrow limit is exceeded'}");
				}
				
			}else {
				return ("{'Fail':'Book is not avaialble'}");
			}
		}else {
			return ("{'Fail':'Borrower or book is not existing'}");
		}
		
		
	}
	
	
	
	@GetMapping("/")
	public String Welcome() {
		
		return "LIBRARY APPLICATION";
	}

	
}
