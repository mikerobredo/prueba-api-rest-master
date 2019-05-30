package com.at.test.curso.controller;
import org.springframework.data.domain.Page;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.at.test.curso.Service.BookServiceImpl;
import com.at.test.curso.model.dto.BookDto;



@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookServiceImpl BookService;
	
	@GetMapping
	public List<BookDto>buscaPorNombre(@RequestParam(value = "name", required = false) String name){
			
		return BookService.todos(name);
	}
	
	 //lo tenia casi pero no lo uso para que funcione algo
	@GetMapping("/pageable")
	public Page<BookDto> buscaPorNombre
			(@RequestParam(value = "name", required = false) String name,
			@RequestParam( value = "page", defaultValue = "5")int page, 
			@RequestParam(value = "size", defaultValue="5") int size){
			
		return BookService.buscaTodosPage(name,PageRequest.of(page, size));
	}
	
	@GetMapping("/{id}")
	public BookDto busca(@PathVariable("id")Integer id)throws com.at.test.curso.Exception.UserNotFoundException
	{	
		return BookService.buscaPorId(id);
	}
	@PutMapping
	public BookDto usoPut(@RequestBody BookDto car)
	{
		return BookService.usaPutModifica(car);
		
	}
	@PostMapping
	public BookDto usoPost(@RequestBody BookDto car)
	{
		return BookService.usaPostCrea(car);
		
	}
	@DeleteMapping("/{id}")
	public void usoDelete(@PathVariable("id")Integer id)
	{
		BookService.usoDelete(id);		
	}
	
}