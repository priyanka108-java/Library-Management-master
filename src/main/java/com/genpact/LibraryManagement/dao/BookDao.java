package com.genpact.LibraryManagement.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.genpact.LibraryManagement.entities.Book;

public interface BookDao extends CrudRepository<Book, Long>{
	
	@Query(
			  value = "SELECT * FROM BOOKS u WHERE u.library_Id = :libId", 
			  nativeQuery = true)
	public Collection<Book> getAllBooks(@Param("libId") String libId);

}
