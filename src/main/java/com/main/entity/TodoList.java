package com.main.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "todolist")
public class TodoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String title;
	
	
	private String description;
	
	
	@Column(columnDefinition = "boolean default false")
	private boolean completed;
	
	
	@Column(name = "createdat")
	private LocalDateTime createdAt;

	@Column(name = "duedate")
	private LocalDate dueDate;
}
