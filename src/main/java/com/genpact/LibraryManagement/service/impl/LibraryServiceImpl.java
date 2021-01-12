package com.genpact.LibraryManagement.service.impl;


import com.genpact.LibraryManagement.service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.genpact.LibraryManagement.beans.LibraryBean;
import com.genpact.LibraryManagement.dao.LibraryDao;
import com.genpact.LibraryManagement.entities.Library;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	LibraryDao libraryDao;

	@Override
	public Library save(LibraryBean library) {
		
          Library entity = new Library();
		
		entity.setName(library.getName());
		entity.setLocation(library.getLocation());
		
		return libraryDao.save(entity);
	}

}
