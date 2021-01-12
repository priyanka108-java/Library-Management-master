package com.genpact.LibraryManagement.controller;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.LibraryManagement.beans.BookBean;
import com.genpact.LibraryManagement.beans.LibraryBean;
import com.genpact.LibraryManagement.entities.Book;
import com.genpact.LibraryManagement.entities.Library;
import com.genpact.LibraryManagement.service.BookService;
import com.genpact.LibraryManagement.service.LibraryService;

@CrossOrigin(origins= {"http://localhost:8089","http://localhost:3000"})
@RestController("/")
public class LibraryController {
	
	//private static final Logger LOGGER=LoggerFactory.getLogger(LibraryController.class);
	
	@Autowired
	LibraryService libraryService;
	
	@Autowired
	BookService bookService;
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception e) {
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="library/create", method=RequestMethod.POST)
	public Library createLibrary(@RequestBody LibraryBean library) {
		
		//LOGGER.info("Started Creating Library");
		
		Library entity = libraryService.save(library);
		
		//LOGGER.info("End : Library created");
		return entity;
	}
	
	@RequestMapping(value="book/create/{libId}", method=RequestMethod.POST)
	public String createBook(@PathVariable String libId ,@RequestBody BookBean book) {
		
		//LOGGER.info("Started Creating Book");
		bookService.save(libId, book);
		//LOGGER.info("End : Book created");
		return "success";
	}
	
	@RequestMapping(value="book/getAll/{libId}", method=RequestMethod.GET)
	public Set<Book> getAllBooks(@PathVariable String libId){
		
		return bookService.getAllBooks(libId);
	}
	
	@RequestMapping(value="book/get/{id}", method=RequestMethod.GET)
	public Optional<Book> getBookByID(@PathVariable String id){
		
		return bookService.getById(id);
	}
	
	@RequestMapping(value="book/update/{id}", method=RequestMethod.PUT)
	public Book updateBook(@PathVariable String id, @RequestBody BookBean bookBean) throws Exception {
		
		//LOGGER.info("Started updating Book");
		return bookService.updateBook(id,bookBean);
	}
	
	@RequestMapping(value="book/delete/{id}", method=RequestMethod.DELETE)
	public String removeBook(@PathVariable String id) {
		//LOGGER.info("Started removing Book");
		bookService.removeBook(id);
		return "success";
	}
	
}
