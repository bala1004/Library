package com.library.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.models.Borrower;
import com.library.repository.BorrowerRepository;

@Component
public class BorrowerDAO {
	@Autowired  
	BorrowerRepository borrowerRepository;  
	
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Borrower> getAllBorrowers()   
	{  
	List<Borrower> borrowers = new ArrayList<Borrower>();  
	borrowerRepository.findAll().forEach(borrower -> borrowers.add(borrower));  
	return borrowers;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Borrower getBorrowerById(long id)   
	{  
	return borrowerRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Borrower borrower)   
	{  
		borrowerRepository.save(borrower);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
//	public void delete(long id)   
//	{  
//	borrowerRepository.deleteById(id);  
//	}  
	//updating a record  
	public void update(Borrower borrower, long id)   
	{  
	borrowerRepository.save(borrower);  
	} 
	
	

}
