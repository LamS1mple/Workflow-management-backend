package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.GroupService;
import com.example.demo.model.Group;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/group")
public class GroupController {
	
	@Autowired
	private GroupService groupService;

	@GetMapping("/get-group/{id}")
	public List<Group> getGroups(@PathVariable("id")long id){
		return groupService.getGroup(id);
	}
	
	@GetMapping("/get-group-{id}")
	public Group getGroup(@PathVariable("id")long id) {
		return groupService.getGroupById(id);
	}
	
}