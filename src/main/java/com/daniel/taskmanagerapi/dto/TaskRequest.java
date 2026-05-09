package com.daniel.taskmanagerapi.dto;

import jakarta.validation.constraints.NotBlank;

public class TaskRequest {

	@NotBlank(message = "Title is required")
	private String title;
	
	@NotBlank(message = "Content is required")
	private String content;
	
	public TaskRequest() {
	}
	
	public TaskRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
