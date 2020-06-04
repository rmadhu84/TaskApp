/**
 * 
 */
package com.madhu.spring.tasks.converter;

import org.springframework.stereotype.Component;

import com.madhu.spring.tasks.dto.TaskDto;
import com.madhu.spring.tasks.model.Task;

/**
 * @author RamachandranM1
 *
 */
@Component
public class TaskDtoToMdlConverter {

	public Task convert(TaskDto input) {
		Task task = new Task();
		task.setId(input.getId());
		task.setName(input.getName());
		task.setDueDate(input.getDueDate());
		task.setCompleted(input.getCompleted());
		return task;
	}
}
