package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.TaskMemberService;
import com.example.demo.dto.request.TaskMemberRequest;
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
	
	@GetMapping("get-all-task-of-user/{id}/{check}")
	public ApiResponse getAllTaskOfUser(@PathVariable("id")long idUser, @PathVariable("check") boolean check){
		return taskMemberService.getAllTaskOfUser(idUser, check);
	}
	@PostMapping("get-task-ahead-schedule")
	public ApiResponse getTaskAhead(@RequestParam("id") long id) {
		return taskMemberService.getTaskAhead(id);
	}
	@PostMapping("get-task-after-schedule")
	public ApiResponse getTaskAfter(@RequestParam("id") long id) {
		return taskMemberService.getTaskAfter(id);
	}
	
	@PostMapping("save-task-member")
	public ApiResponse saveTaskMember(@RequestBody TaskMemberRequest taskMember) {
		System.out.println(taskMember.toString());
		return taskMemberService.saveTaskmember(taskMember);
	}
	
	@GetMapping("get-task-member/{id}")
	public TaskMember getTaskId(@PathVariable("id")long id) {
		return taskMemberService.getTaskId(id);
	}
	@GetMapping("delete-task/{id}")
	public void deleteTaskId(@PathVariable("id")long id) {
		taskMemberService.deleteDetail(id);
	}
	@PostMapping("/save-task")
	public void saveTaskMember(@RequestBody TaskMember taskMember) {
		taskMemberService.saveUpdateTask(taskMember);
	}
}
