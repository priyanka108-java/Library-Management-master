/*package com.genpact.LibraryManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.LibraryManagement.beans.BookBean;
import com.genpact.LibraryManagement.service.BookService;

@RestController("book/")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value="create/{libId}", method=RequestMethod.POST)
	public String createBook(@PathVariable String libId ,@RequestBody BookBean book) {
		
		bookService.save(libId, book);
		
		return "success";
	}
	
}
*/