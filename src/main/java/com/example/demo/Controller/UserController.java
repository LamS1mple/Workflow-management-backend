package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.model.User;



@RestController
@RequestMapping("user")
@CrossOrigin(value = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login-user")
	public ResponseEntity<ApiResponse> loginUser(@RequestBody UserRequest userRequest){
		
		return userService.loginService(userRequest);
	}
}
