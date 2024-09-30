package com.main.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TodoRequest {

private String title;
	
	
	private String description;
	
	
	@Column(columnDefinition = "boolean default false")
	private boolean completed;
	private LocalDate dueDate;
}

