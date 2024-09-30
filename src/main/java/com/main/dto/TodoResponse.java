package com.main.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TodoResponse {
	private int id;
	private String title;
	
	
	private String description;
	
	
	@Column(columnDefinition = "boolean default false")
	private boolean completed;
	
	 private LocalDateTime createdAt; // New field for timestamp
	    private LocalDate dueDate; 
}
