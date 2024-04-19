package com.example.demo.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Task;

@Repository
public interface TaskReponsitory extends JpaRepository<Task, Long>{
	
//	@Query (value = "select * from task, post where id_task = ?1 and id = ?1")
//	Task findTaskOfTaskMember(long id_task);

}
