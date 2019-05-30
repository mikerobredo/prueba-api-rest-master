package com.at.test.curso.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.at.test.curso.model.dto.BookDto;

public interface BookService {
	
	public List<BookDto>  todos(String s);
	public BookDto buscaPorId(Integer id)throws com.at.test.curso.Exception.UserNotFoundException;
	public BookDto usaPutModifica(BookDto libro);
	public BookDto usaPostCrea(BookDto libro);
	public void usoDelete(Integer id);
	public List<BookDto> buscaPorNombre(String name);
	public Page<BookDto> buscaTodosPage(String name,Pageable pageable);
}