/**
 * 
 */
package com.madhu.spring.tasks.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.madhu.spring.tasks.converter.TaskDtoToMdlConverter;
import com.madhu.spring.tasks.converter.TaskMdlToDtoConverter;
import com.madhu.spring.tasks.dto.TaskDto;
import com.madhu.spring.tasks.model.Task;
import com.madhu.spring.tasks.repository.TaskRepository;

import lombok.Data;

/**
 * @author RamachandranM1
 *
 */
@Data
@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepository repo;
	private TaskMdlToDtoConverter taskMdlToDtoConverter;
	private TaskDtoToMdlConverter taskDtoToMdlConverter;

	
	public TaskServiceImpl(TaskRepository repo, TaskMdlToDtoConverter taskMdlToDtoConverter,
			TaskDtoToMdlConverter taskDtoToMdlConverter) {
		super();
		this.repo = repo;
		this.taskMdlToDtoConverter = taskMdlToDtoConverter;
		this.taskDtoToMdlConverter = taskDtoToMdlConverter;
	}

	@Override
	public String deleteTask(TaskDto task) {
		repo.delete(taskDtoToMdlConverter.convert(task));
		return SUCCESS;
	}

	@Override
	public List<TaskDto> getTasks() {
		List<TaskDto> tasks = new ArrayList<TaskDto>();
		repo.findAll().forEach(task -> {
			tasks.add(taskMdlToDtoConverter.convert(task));
		});
		return tasks;
	}

	@Override
	public TaskDto saveTask(TaskDto task) {
		// TODO Auto-generated method stub
		TaskDto dto = taskMdlToDtoConverter.convert(repo.save(taskDtoToMdlConverter.convert(task)));
		return dto;
	}

}
