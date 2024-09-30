package com.main.translate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dto.TodoRequest;
import com.main.dto.TodoResponse;
import com.main.entity.TodoList;

@Component
public class Translator {
	@Autowired
	 private final ObjectMapper objectMapper;

    public Translator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    
    public TodoResponse responseentity(TodoList list) {
    	TodoResponse response = objectMapper.convertValue(list, TodoResponse.class);
    	 response.setCreatedAt(list.getCreatedAt());  // Ensure createdAt is included
         response.setDueDate(list.getDueDate());      // Include due date
         return response;
    	
    	
    }
    
    public TodoList requestentity(TodoRequest request) {
    	TodoList entity =  objectMapper.convertValue(request, TodoList.class);
    	entity.setDueDate(request.getDueDate()); // Set due date from request
        return entity;
    }
    
    
    public List<TodoResponse> responseentity(List<TodoList> list){
    	return list.stream().map(li -> objectMapper.convertValue(li, TodoResponse.class)).collect(Collectors.toList());
    			}
}
