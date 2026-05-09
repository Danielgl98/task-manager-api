package com.daniel.taskmanagerapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.taskmanagerapi.dto.TaskRequest;
import com.daniel.taskmanagerapi.dto.TaskResponse;
import com.daniel.taskmanagerapi.model.Task;
import com.daniel.taskmanagerapi.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	
	@PostMapping
	public TaskResponse saveTask(@Valid @RequestBody TaskRequest taskRequest) {
		Task t = taskService.saveTask(taskRequest.getTitle(), taskRequest.getContent());
		
		return new TaskResponse(t.getId(), t.getTitle(), t.getContent(), t.isCompleted());
	}
	
	@GetMapping
	public List<TaskResponse> getAll(){
		List<Task> tasks = taskService.getAll();
		List<TaskResponse> tasksResponse = new ArrayList<>();
		
		for(Task t: tasks) {
			tasksResponse.add(new TaskResponse(t.getId(), t.getTitle(), t.getContent(), t.isCompleted()));
		}
		
		return tasksResponse;
	}
	
	@GetMapping("/{id}")
	public TaskResponse getById(@PathVariable Long id) {
		Task t = taskService.getById(id);
		
		return new TaskResponse(t.getId(), t.getTitle(), t.getContent(), t.isCompleted());
	}
	
	@PutMapping("/{id}/complete")
	public TaskResponse completeTask(@PathVariable Long id) {
		Task t = taskService.completeTask(id);
		
		return new TaskResponse(t.getId(), t.getTitle(), t.getContent(), t.isCompleted());
	}
	
	@DeleteMapping("{id}")
	public TaskResponse deleteTask(@PathVariable Long id) {
		Task t = taskService.deleteTask(id);
		
		return new TaskResponse(t.getId(), t.getTitle(), t.getContent(), t.isCompleted());
	}
}
