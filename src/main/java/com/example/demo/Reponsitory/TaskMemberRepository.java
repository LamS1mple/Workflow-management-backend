package com.example.demo.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaskMember;
import com.example.demo.model.User;

import java.util.Date;
import java.util.List;


@Repository
public interface TaskMemberRepository extends JpaRepository<TaskMember, Long>{
	
	List<TaskMember> findByUser(User user);

	List<TaskMember> findByUserAndIsFinish(User user, boolean check);

	List<TaskMember> findByUserAndDateFinishAfter(User user, Date date);

	List<TaskMember> findByUserAndDateFinishBefore(User user, Date date);

}
