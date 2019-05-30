package com.at.test.curso.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.AssertTrue;

import lombok.Data;

@Data
public class BookDto {
	
	private Integer id;	
	
	private String isbn;
	@NotNull
	private String name;
	@NotNull
	private String synopsis;
	@NotNull
	private Integer pages;

}
