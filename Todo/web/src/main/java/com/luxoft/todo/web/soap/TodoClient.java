package com.luxoft.todo.web.soap;


import com.luxoft.todo.web.converters.Converter;
import com.luxoft.todo.web.converters.ListConverter;
import com.luxoft.todo.web.model.FilterDto;
import com.luxoft.todo.web.model.TodoDto;
import com.luxoft.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;


public class TodoClient extends WebServiceGatewaySupport {

    public List<TodoDto> getAllTodo() {
        TodoRequest request = new TodoRequest();
        GetTodoResponse response = (GetTodoResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/todoRequest"));
        return ListConverter.convertToTodoDtoList(response.getAllTodo());

    }

    public List<TodoDto> removeTodo(String id) {
        RemoveRequest request = new RemoveRequest();
        request.setId(id);
        GetTodoResponse response = (GetTodoResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/removeRequest"));
        return ListConverter.convertToTodoDtoList(response.getAllTodo());
    }

    public TodoDto addTodo(String todo) {
        AddTodo request = new AddTodo();
        request.setTodo(todo);
        AddTodoResponse response = (AddTodoResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/addTodo"));
        return Converter.convertToLocalDateTimeDate(response.getTodo());
    }

    public List<TodoDto> updateTodo(TodoDto todoDto) {
        UpdateTodo request = new UpdateTodo();
        request.setTodo(Converter.convertToLongDate(todoDto));
        GetTodoResponse response = (GetTodoResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/updateTodo"));
        return ListConverter.convertToTodoDtoList(response.getAllTodo());
    }

    public List<TodoDto> filterTodo(FilterDto filterDto) {
        FilterTodo request = Converter.convertToSoapFilter(filterDto);
        FilterTodoResponse response = (FilterTodoResponse) getWebServiceTemplate().marshalSendAndReceive(
                request, new SoapActionCallback("http://localhost:8080/soapws/filterTodo"));
        return ListConverter.convertToTodoDtoList(response.getFilteredTodo());
    }

}
