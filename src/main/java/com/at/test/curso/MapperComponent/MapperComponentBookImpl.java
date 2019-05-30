package com.at.test.curso.MapperComponent;

import org.springframework.stereotype.Component;


import com.at.test.curso.model.BookModel;
import com.at.test.curso.model.dto.BookDto;


@Component
public class MapperComponentBookImpl implements MapperComponent<BookDto,BookModel>{

	@Override
	public BookDto toDto(BookModel model) {
		BookDto b = new BookDto();
		
		b.setIsbn(model.getIsbn());
		b.setName(model.getName());
		b.setId(model.getId());
		b.setPages(model.getPages());
		b.setSynopsis(model.getSynopsis());
		
		return b;
	}

	@Override
	public BookModel toModel(BookDto mDto) {
		
		BookModel b = new BookModel();
		b.setName(mDto.getName());
		b.setIsbn(mDto.getIsbn());
		b.setId(mDto.getId());
		b.setPages(mDto.getPages());
		b.setSynopsis(mDto.getSynopsis());
		
		return b;
	}

}


