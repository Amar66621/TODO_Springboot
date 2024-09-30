package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.TodoRequest;
import com.main.dto.TodoResponse;

import com.main.service.TodoService;




@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TodoService service;
	
	 @GetMapping("/fetch")
	    public ResponseEntity<List<TodoResponse>> getAllTodos() {
	        List<TodoResponse> todos = service.getAlllist();
	        return ResponseEntity.ok(todos);
	    }
	 
	 @GetMapping("/fetch/{id}")
	    public ResponseEntity<TodoResponse> getTodoById(@PathVariable int id) {
	        TodoResponse todo = service.getbyid(id);
	        if (todo != null) {
	            return ResponseEntity.ok(todo);
	        } else {
	            return ResponseEntity.ok(null);
	        }
	    }
	 
	 
	 @PostMapping("/add")
	    public ResponseEntity<TodoResponse> createTodo(@RequestBody TodoRequest todoRequest) {
	        TodoResponse newTodo = service.save(todoRequest);
	        return ResponseEntity.ok(newTodo);
	    }
	 
	 @PutMapping("/upadte/{id}")
	    public ResponseEntity<TodoResponse> updateTodo(@PathVariable int id, @RequestBody TodoRequest todoRequest) {
	        TodoResponse updatedTodo = service.updateTodo(id, todoRequest);
	        if (updatedTodo != null) {
	            return ResponseEntity.ok(updatedTodo);
	        } else {
	            return ResponseEntity.ok(null);
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	    public void deleteTodoById(@PathVariable int id) {
	        service.deletebyid(id);
	        
	    }
	 
	 
	 @PutMapping("/{id}/complete")
	    public ResponseEntity<TodoResponse> markTodoAsCompleted(@PathVariable int id) {
	        TodoResponse completedTodo = service.markTodoAsCompleted(id);
	        if (completedTodo != null) {
	            return ResponseEntity.ok(completedTodo);
	        } else {
	            return ResponseEntity.ok(null);
	        }
	    }
}
