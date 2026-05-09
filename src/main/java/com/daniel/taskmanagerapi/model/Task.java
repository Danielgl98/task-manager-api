package com.daniel.taskmanagerapi.model;

public class Task {

	private final Long id;
	private final String title;
	private final String content;
	private boolean completed;
	
	private static Long nextId=1L;
	
	public Task(String title, String content) {
		id = nextId;
		
		if(title == null || title.isBlank()) {
			throw new IllegalArgumentException("Title is required");
		}
		
		if(content == null || content.isBlank()) {
			throw new IllegalArgumentException("Content is required");
		}
		
		this.title = title;
		this.content = content;
		completed = false;
		
		nextId++;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void completeTask() {
		if(completed) {
			throw new IllegalStateException("The task is already finished");
		}
		
		completed = true;
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
	
	@Override
	public String toString() {
		return "Task ID: " + id + " |Title: " + title + " |Content: " + content + " |Completed: " + completed;
	}
}
