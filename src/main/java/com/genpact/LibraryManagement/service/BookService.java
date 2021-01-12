package com.genpact.LibraryManagement.service;

import java.util.Set;
import java.util.Optional;

import com.genpact.LibraryManagement.beans.BookBean;
import com.genpact.LibraryManagement.entities.Book;

public interface BookService {

	public String save(String libId,BookBean bookBean);
	
	public Set<Book> getAllBooks(String libId);
	
	public Optional<Book> getById(String id);
	
	public Book updateBook(String id, BookBean bookBean) throws Exception;
	
	public void removeBook(String id); 
}
