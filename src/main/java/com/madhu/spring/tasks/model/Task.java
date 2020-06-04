/**
 * 
 */
package com.madhu.spring.tasks.model;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author RamachandranM1
 *
 */
@Entity
@Data
@AllArgsConstructor
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name ="due_date")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dueDate;
	
	@Column(name = "task_completed")
	private Boolean completed;

	public Task() {
		this.completed = false;
	}
	
	
}
