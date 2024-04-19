package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Reponsitory.UserRepository;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.model.User;

import jakarta.persistence.EntityManager;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EntityManager entityManager;
	public ResponseEntity<ApiResponse> loginService(UserRequest userRequest){
		User user = userRepository.findByUserNameAndPassWord(userRequest.userName(), userRequest.passWord());
//	
//		User user =  entityManager.createQuery("select id, img, name, passWord, userName from user where userName = ?1 and passWord = ?2", User.class)
//				.setParameter(1, userRequest.userName())
//				.setParameter(2, userRequest.passWord())
//				.getSingleResult();
		
		if (user == null) throw new NullPointerException("User is not exits");
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setResult( user);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.ACCEPTED);
		
		
		
		
	}
}
