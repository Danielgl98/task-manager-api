package com.daniel.taskmanagerapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniel.taskmanagerapi.model.Task;
import com.daniel.taskmanagerapi.repository.TaskRepository;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public Task saveTask(String title, String content) {
		Task t = new Task(title, content);
		
		return taskRepository.save(t);
		
	}
	
	public List<Task> getAll(){
		return taskRepository.findAll();
	}
	
	public Task getById(Long id) {
		validateId(id);
		
		return taskRepository.findById(id)
				.orElseThrow(() -> 
						new IllegalArgumentException(
								"Task wasn't found"
						));
	}
	
	public Task completeTask(Long id) {
		Task t = getById(id);
		
		t.completeTask();
		return taskRepository.save(t);
	}
	
	public Task updateTask(Long id, String title, String content) {
		Task t = getById(id);
		t.updateTask(title, content);
		
		return taskRepository.save(t);
	}
	
	public Task deleteTask(Long id) {
		Task t = getById(id);
		
		taskRepository.delete(t);
		
		return t;
	}
	
	//Validates
	private void validateId(Long id) {
		if(id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid ID");
		}
	}
}
