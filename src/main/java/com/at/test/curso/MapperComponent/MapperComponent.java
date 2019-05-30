package com.at.test.curso.MapperComponent;

public interface MapperComponent<T,S> {
		T toDto(S model);
		S toModel(T mDto);
	}