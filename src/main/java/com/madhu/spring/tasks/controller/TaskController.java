/**
 * 
 */
package com.madhu.spring.tasks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.spring.tasks.dto.TaskDto;
import com.madhu.spring.tasks.service.TaskService;

/**
 * @author RamachandranM1
 *
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/tasks")
public class TaskController {

	private TaskService service;

	public TaskController(TaskService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = { "", "/","/getAllTasks" })
	public Iterable<TaskDto> listTasks() {
		return service.getTasks();
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveTask(@RequestBody TaskDto task) {
		return ResponseEntity.status(HttpStatus.OK).body(service.saveTask(task));
	}

	@PostMapping(value = "/delete")
	public ResponseEntity<Object> deleteTask(@RequestBody TaskDto task) {
		if (service.deleteTask(task) == service.SUCCESS)
			return ResponseEntity.status(HttpStatus.OK).body("Task deleted");
		else
			return ResponseEntity.status(HttpStatus.OK).body("Deletion Failed");
	}

}
