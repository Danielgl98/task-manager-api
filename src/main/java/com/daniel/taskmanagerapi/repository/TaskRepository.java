package com.daniel.taskmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.taskmanagerapi.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
