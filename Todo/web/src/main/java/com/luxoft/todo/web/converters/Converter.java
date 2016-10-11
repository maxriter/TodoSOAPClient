package com.luxoft.todo.web.converters;


import com.luxoft.todo.web.model.FilterDto;
import com.luxoft.todo.web.model.TodoDto;
import com.luxoft.wsdl.FilterTodo;
import com.luxoft.wsdl.Todo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public final class Converter {

	public static TodoDto convertToLocalDateTimeDate(Todo todo) {
		TodoDto convertedDto = new TodoDto();
		convertedDto.setId(todo.getId());
		convertedDto.setTodo(todo.getTodo());
		convertedDto.setDateTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(todo.getDateTime()), ZoneId.systemDefault()));
		return convertedDto;
	}

	public static Todo convertToLongDate(TodoDto todoDto) {
		Todo convertedDto = new Todo();
		convertedDto.setId(todoDto.getId());
		convertedDto.setTodo(todoDto.getTodo());
		if (todoDto.getDateTime() != null) {
			convertedDto.setDateTime(todoDto.getDateTime().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli());
		}
		return convertedDto;
	}

	public static FilterTodo convertToSoapFilter(FilterDto filterDto) {
		FilterTodo filterTodo = new FilterTodo();
		filterTodo.setTodo(filterDto.getTodo());
		filterTodo.setDateFrom(filterDto.getDateFrom());
		filterTodo.setDateTo(filterDto.getDateTo());
		return filterTodo;
	}

}
