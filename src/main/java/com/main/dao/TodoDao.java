package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.entity.TodoList;
import com.main.repository.TodoRepository;

@Repository
public class TodoDao {
	@Autowired
	private TodoRepository repository;
	
	public List<TodoList> getList(){
		return repository.findAll();
	}
	
	public TodoList save(TodoList list) {
		return repository.save(list);
	}
	
	public TodoList getbyid( int id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public void deletebyid(int id) {
		repository.deleteById(id);
	}
	
	public void markasCompleted(int id) {
		TodoList list = repository.findById(id).orElse(null);
		if(list != null) {
			list.setCompleted(true);
			repository.save(list);
		}
	}
}
