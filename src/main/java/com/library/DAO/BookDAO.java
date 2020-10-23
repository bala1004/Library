package com.library.DAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.models.Book;
import com.library.models.Borrower;
import com.library.repository.BookRepository;

@Component
public class BookDAO {

	@Autowired  
	BookRepository bookRepository;  
	
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Book> getAllBooks()   
	{  
	List<Book> books = new ArrayList<Book>();  
	bookRepository.findAll().forEach(book -> books.add(book));  
	return books;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Book getBookById(long id)   
	{  
	return bookRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Book book)   
	{  
	bookRepository.save(book);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
//	public void delete(long id)   
//	{  
//	bookRepository.deleteById(id);  
//	}  
	//updating a record  
	public void update(Book book, long id)   
	{  
	bookRepository.save(book);  
	}  
	
	public Book getBookByBorrower(Borrower b)   
	{ 
		return bookRepository.findByBorrower(b);
	} 
}
