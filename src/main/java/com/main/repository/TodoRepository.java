package com.main.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.TodoList;

public interface TodoRepository extends JpaRepository<TodoList, Integer> {
	
}
