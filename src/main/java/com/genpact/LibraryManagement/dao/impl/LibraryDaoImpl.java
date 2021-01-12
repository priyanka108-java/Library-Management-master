/*package com.genpact.LibraryManagement.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.genpact.LibraryManagement.dao.LibraryDao;
import com.genpact.LibraryManagement.entities.Library;

@Repository
public class LibraryDaoImpl implements LibraryDao {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public <S extends Library> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Library> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Library> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Library> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Library entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Library> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Library save(Library library) {
		
		
		
		entityManager.persist(library);
		
		return library;
	}
	
}
*/