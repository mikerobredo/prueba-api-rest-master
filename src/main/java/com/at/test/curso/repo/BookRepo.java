package com.at.test.curso.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.at.test.curso.model.BookModel;

public interface BookRepo extends JpaRepository<BookModel,Integer>{
	List<BookModel> findByNameContaining(String s);
	Page<BookModel> findAll(Pageable page);
}