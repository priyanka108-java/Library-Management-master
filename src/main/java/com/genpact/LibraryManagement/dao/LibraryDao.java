package com.genpact.LibraryManagement.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.genpact.LibraryManagement.entities.Library;


public interface LibraryDao extends CrudRepository<Library, Long> {
	
	public Library save(Library library);
	
	public Optional<Library> findById(String libId);

}
