package com.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class LoanRecord {
	@Id
	@Column(name="loan_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "borrower_id", nullable = true)
	private Borrower borrower;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = true)
	private Book book;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
