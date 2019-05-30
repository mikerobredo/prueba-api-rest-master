package com.at.test.curso.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.at.test.curso.Exception.UserNotFoundException;
import com.at.test.curso.MapperComponent.MapperComponent;
import com.at.test.curso.model.BookModel;
import com.at.test.curso.model.dto.BookDto;
import com.at.test.curso.repo.BookRepo;




@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private MapperComponent<BookDto, BookModel> servicioBooks;
	
	@Autowired
	private BookRepo BookControlador;

	@Override
	public List<BookDto> todos(String s) {
		if (s!=null)
		{
			return buscaPorNombre(s);
		}
		
		List<BookModel> lc = BookControlador.findAll();
		List<BookDto> lcDto = new ArrayList<BookDto>();
		for(BookModel c: lc)
		{
			lcDto.add(servicioBooks.toDto(c));
		}
		return  lcDto;		
	}

	@Override
	public BookDto buscaPorId(Integer id)  throws UserNotFoundException{
		
		Optional<BookModel> c1= BookControlador.findById(id);
		BookDto c2= servicioBooks.toDto(c1.orElse(new BookModel()));///debo devover excepccion
		return c2;/*
		BookModel c1 = BookControlador.getOne(id);
		BookDto c2= servicioBooks.toDto(c1);///debo devover excepccion
		System.out.println(c2.getIsbn());
		/*
		if (c2.getIsbn()=="null")
		{
			
			throw new UserNotFoundException();
		}*/
		
	}

	@Override
	public BookDto usaPutModifica(BookDto libro) {
		BookModel a =BookControlador.save(servicioBooks.toModel(libro));			
		return servicioBooks.toDto(a) ;
	}

	@Override
	public BookDto usaPostCrea(BookDto libro) {			
		return servicioBooks.toDto((BookControlador.save(servicioBooks.toModel(libro))));
	}

	@Override
	public void usoDelete(Integer id) {				
		BookControlador.delete(BookControlador.getOne(id));			
	}

	@Override
	public List<BookDto> buscaPorNombre(String name) {		
		List<BookModel> lc = BookControlador.findByNameContaining(name);
		List<BookDto> lcDto = new ArrayList<BookDto>();
		for(BookModel c: lc)
		{
			lcDto.add(servicioBooks.toDto(c));
		}
		return  lcDto;
	}
	
	@Override
	public Page<BookDto> buscaTodosPage(String name, Pageable p) {
		Page<BookModel> lc = BookControlador.findAll(p);		
		return lc.map(x -> servicioBooks.toDto(x));	
	}	
}
