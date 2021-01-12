package com.genpact.LibraryManagement;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.genpact.LibraryManagement.controller.LibraryController;
import com.genpact.LibraryManagement.beans.BookBean;
import com.genpact.LibraryManagement.beans.LibraryBean;
import com.genpact.LibraryManagement.entities.Library;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class LibraryManagementApplicationTests {

	
	
	@Autowired
	LibraryController libraryController;

	private LibraryBean library;
	
	private LibraryBean library2;

	private BookBean book;
	
	private BookBean book2;


	@Before
	public void setUp() {
		library = new LibraryBean("PayPal", "Texas");
		library2 = new LibraryBean("PayPal Central", "Ohio");
		book = new BookBean("Spring Data JPA", "Priyanka","BNHJ786",2000);
		book2 = new BookBean("Core Java", "Priyanka","BNHJ780",3000);
		

	}

	@Test
	public void saveLibrary() {
		Library entity = libraryController.createLibrary(library);
		assertThat(entity.getName()).isEqualTo("PayPal");

	}

	@Test
	public void saveBooks() {

		Library entity = libraryController.createLibrary(library2);
		String statusBook = libraryController.createBook(String.valueOf(entity.getId()),book);

		assertThat(statusBook).isEqualTo("success");

	}

}