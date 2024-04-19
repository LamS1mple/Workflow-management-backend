package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.TaskMemberService;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.model.TaskMember;
import com.example.demo.model.User;

@RestController
@RequestMapping("/task")
@CrossOrigin(value = "*")
public class TaskController {

	@Autowired
	private TaskMemberService taskMemberService;
	
	@GetMapping("/get-all-task-of-user/{id}")
	public ResponseEntity<ApiResponse> getAllTask(@PathVariable(value = "id") long id){
		User user = new User();
		user.setId(id);
		List<TaskMember> listTaskMembers = taskMemberService.findTaskByUser(user);
		ApiResponse apiResponse = ApiResponse.builder()
				.code(1000)
				.result(listTaskMembers)
				.build();
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("task/get-all-task-of-user/{id}/{check}")
	public List<TaskMember> getAllTaskOfUser(@PathVariable("id")int idUser, @PathVariable("check") boolean check){
		return taskMemberService.getAllTaskOfUser(idUser, check);
	}
}
