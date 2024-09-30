package com.main.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.TodoDao;
import com.main.dto.TodoRequest;
import com.main.dto.TodoResponse;
import com.main.entity.TodoList;
import com.main.translate.Translator;



@Service
public class TodoService {
	
	@Autowired
	private TodoDao dao;
	@Autowired
	private Translator trans;
	
	public List<TodoResponse> getAlllist(){
		List<TodoList> todos = dao.getList();
        return trans.responseentity(todos);
	}
	
	
	public TodoResponse getbyid(int id) {
		TodoList list =  dao.getbyid(id);
		return trans.responseentity(list);
	}
	
	public TodoResponse save(TodoRequest req) {
		TodoList todo = trans.requestentity(req);
		 todo.setCreatedAt(java.time.LocalDateTime.now());
		 
		 TodoList savedtodo= dao.save(todo);
		 return trans.responseentity(savedtodo);
	}
	
	public void deletebyid(int id) {
		 dao.deletebyid(id);
	}
	
	
	 public TodoResponse updateTodo(int id, TodoRequest request) {
		 TodoList existingTodo = dao.getbyid(id);
	        if (existingTodo != null) {
	            existingTodo.setTitle(request.getTitle());
	            existingTodo.setDescription(request.getDescription());
	            existingTodo.setDueDate(request.getDueDate());
	            existingTodo.setCompleted(request.isCompleted());

	            TodoList updatedTodo = dao.save(existingTodo);
	            return trans.responseentity(updatedTodo);
	        }
	        return null; // Task not found
	    }
	 
	 
	 public TodoResponse markTodoAsCompleted(int id) {
	        TodoList existingTodo = dao.getbyid(id);
	        if (existingTodo != null) {
	            dao.markasCompleted(id);
	            return trans.responseentity(existingTodo);
	        }
	        return null;
	 }
}
