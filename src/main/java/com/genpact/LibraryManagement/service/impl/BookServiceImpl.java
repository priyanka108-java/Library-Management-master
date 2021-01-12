package com.genpact.LibraryManagement.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.LibraryManagement.beans.BookBean;
import com.genpact.LibraryManagement.dao.BookDao;
import com.genpact.LibraryManagement.dao.LibraryDao;
import com.genpact.LibraryManagement.entities.Book;
import com.genpact.LibraryManagement.entities.Library;
import com.genpact.LibraryManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	LibraryDao libraryDao;
	
	@Autowired
	EntityManager em;

  public String save(String libId,BookBean bookBean) {
	  
	  Optional<Library> library = libraryDao.findById(Long.valueOf(libId));
	  
	  Library libraryNew = new Library();
	  if(library.isPresent()) {
		  libraryNew = library.get();
	  }
	  
	  Book book = new Book();
	  book.setTitle(bookBean.getTitle());
	  book.setAuthor(bookBean.getAuthor());
	  book.setIsbn(bookBean.getIsbn());
	  book.setCost(bookBean.getCost());
	  book.setLibrary(libraryNew);
	  
	  Book bookSaved = bookDao.save(book);
	  
	  Set<Book> books = new HashSet<>();
	  books.add(bookSaved);
	  
	  libraryNew.setBooks(books);
	  
	  libraryDao.save(libraryNew);
		
	  return "success";
	}
  
  public Set<Book> getAllBooks(String libId){
	  
      List<Book> bookList = (List<Book>)bookDao.getAllBooks(libId);
      Set<Book> bookSet = new HashSet<Book>(bookList);
      return bookSet;
  }
  
  @Override
  public Optional<Book> getById(String id) {
	  
	 
	  return bookDao.findById(Long.valueOf(id));
  }
  
  public Book updateBook(String id, BookBean bookBean) throws Exception {
	  
   Optional<Book> book = bookDao.findById(Long.valueOf(id));
	  
	  Book bookNew = new Book();
	  if(book.isPresent()) {
		  bookNew = book.get();
		  bookNew.setTitle(bookBean.getTitle());
		  bookNew.setAuthor(bookBean.getAuthor());
		  bookNew.setIsbn(bookBean.getIsbn());
		  bookNew.setCost(bookBean.getCost());
		  
		  return bookDao.save(bookNew);
	  }else {
		  throw new Exception("Book Not available!!");
	  }
  }

  public void removeBook(String id) {
	  bookDao.deleteById(Long.valueOf(id));
  }
  
}
