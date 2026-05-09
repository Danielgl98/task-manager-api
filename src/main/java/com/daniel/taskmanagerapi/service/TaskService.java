package com.daniel.taskmanagerapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.daniel.taskmanagerapi.model.Task;

@Service
public class TaskService {

	private final Map<Long, Task> tasks = new HashMap<>();
	
	public Task saveTask(String title, String content) {
		Task t = new Task(title, content);
		tasks.put(t.getId(), t);
		
		return t;
	}
	
	public List<Task> getAll(){
		return new ArrayList<>(tasks.values());
	}
	
	public Task getById(Long id) {
		validateId(id);
		
		Task t = tasks.get(id);
		
		if(t == null) {
			throw new IllegalArgumentException("The task wasn't found");
		}
		
		return t;
	}
	
	public Task completeTask(Long id) {
		Task t = getById(id);
		
		t.completeTask();
		return t;
	}
	
	public Task deleteTask(Long id) {
		Task t = tasks.remove(id);
		
		if(t == null) {
			throw new IllegalArgumentException("The task wasn't found");
		}
		
		return t;
	}
	
	//Validates
	private void validateId(Long id) {
		if(id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid ID");
		}
	}
}
