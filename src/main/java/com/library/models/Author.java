package com.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Author")
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    private Long id;

	@Column(name = "first_name")
	private String fName;
	
	@Column(name = "last_name")
	private String lName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", nullable = true, unique = true)
	private Book book;
	
	public Author() {	
		
	}

	public Author(String fname, String lname) {
		super();
		this.fName = fname;
		this.lName = lname;
	}

	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	@Override
	public String toString() {
		return "Author [fName=" + fName + ", lName=" + lName + "]";
	}
	
}
