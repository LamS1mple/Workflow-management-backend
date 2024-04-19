package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Reponsitory.TaskMemberRepository;
import com.example.demo.model.TaskMember;
import com.example.demo.model.User;

@Service
public class TaskMemberService {

	@Autowired
	private TaskMemberRepository taskMemberRepository;
	
	public List<TaskMember> findTaskByUser(User user){
		List<TaskMember> listTaskMembers = taskMemberRepository.findByUser(user);
		if (listTaskMembers == null) throw new NullPointerException("Current, You have not task");
		return listTaskMembers;
	}

	
}
