package com.daniel.taskmanagerapi.dto;

public class TaskResponse {

	private final Long id;
	private final String title;
	private final String content;
	private final boolean completed;
	
	public TaskResponse(Long id, String title, String content, boolean completed) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public boolean isCompleted() {
		return completed;
	}
	
	
	
}
