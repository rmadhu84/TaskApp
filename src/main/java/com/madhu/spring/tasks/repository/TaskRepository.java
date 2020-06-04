/**
 * 
 */
package com.madhu.spring.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.spring.tasks.model.Task;

/**
 * @author RamachandranM1
 *
 */
public interface TaskRepository extends JpaRepository<Task, Long>{

}
