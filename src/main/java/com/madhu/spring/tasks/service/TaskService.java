/**
 * 
 */
package com.madhu.spring.tasks.service;

import com.madhu.spring.tasks.dto.TaskDto;

/**
 * @author RamachandranM1
 *
 */
public interface TaskService {
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";

	public Iterable<TaskDto> getTasks();
	
	public TaskDto saveTask(TaskDto task);
	
	public String deleteTask(TaskDto task);
}
