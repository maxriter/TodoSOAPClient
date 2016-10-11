package com.luxoft.todo.web.converters;



import com.luxoft.todo.web.model.TodoDto;
import com.luxoft.wsdl.Todo;

import java.util.ArrayList;
import java.util.List;


public class ListConverter {

	public static List<TodoDto> convertToTodoDtoList(List<Todo> list) {
		List<TodoDto> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			result.add(Converter.convertToLocalDateTimeDate(list.get(i)));
		}
		return result;
	}
}
