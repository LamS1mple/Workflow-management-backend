package com.example.demo.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaskMember;
import com.example.demo.model.User;

import java.util.List;


@Repository
public interface TaskMemberRepository extends JpaRepository<TaskMember, Long>{
	
	List<TaskMember> findByUser(User user);

}
