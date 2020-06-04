/**
 * 
 */
package com.madhu.spring.tasks.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author RamachandranM1
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

	private Long id;
	
	private String name;
	
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dueDate;
	
	private Boolean completed;
}
