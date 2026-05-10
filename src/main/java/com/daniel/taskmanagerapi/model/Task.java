package com.daniel.taskmanagerapi.model;
import jakarta.persistence.*;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private boolean completed;
	
	
	public Task() {
	}
	
	public Task(String title, String content) {
		
		if(title == null || title.isBlank()) {
			throw new IllegalArgumentException("Title is required");
		}
		
		if(content == null || content.isBlank()) {
			throw new IllegalArgumentException("Content is required");
		}
		
		this.title = title;
		this.content = content;
		completed = false;
		
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
	
	public void updateTask(String title, String content) {
		if(title == null || title.isBlank()) {
			throw new IllegalArgumentException("Title is required");
		}
		
		if(content == null || content.isBlank()) {
			throw new IllegalArgumentException("Content is required");
		}
		
		this.title = title;
		this.content = content;
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
