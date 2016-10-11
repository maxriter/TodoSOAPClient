package com.luxoft.todo.web;

import com.luxoft.todo.web.model.FilterDto;
import com.luxoft.todo.web.model.TodoDto;
import com.luxoft.todo.web.soap.TodoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    TodoClient todoClient;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public List<TodoDto> getAllTodo() {
        List<TodoDto> res = todoClient.getAllTodo();
        return res;
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public TodoDto addTodo(@RequestBody TodoDto todoDto) {
        return todoClient.addTodo(todoDto.getTodo());
    }

    @RequestMapping(value = "/item/{todoId}", method = RequestMethod.DELETE)
    public List<TodoDto> removeTodo(@PathVariable Long todoId) {
        todoClient.removeTodo(String.valueOf(todoId));
        return todoClient.getAllTodo();
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public List<TodoDto> updateTodo(@RequestBody TodoDto todoDto) {
        todoClient.updateTodo(todoDto);
        return todoClient.getAllTodo();
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
	public List<TodoDto> searchTodo(@RequestBody FilterDto filter ) {
		return todoClient.filterTodo(filter);
	}

}
