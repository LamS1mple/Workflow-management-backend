package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity(name = "user")
public class User{

	@Id
	@GeneratedValue
	private long id;
	
	
	private String name;
	
	private String userName;
	
	private String passWord;
	
	@Column(columnDefinition = "BLOB")
	private byte[] img;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<GroupMember> listGroupJoin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hostGroup")
	private List<Group> listGroupHost;
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<TaskMember> listTaskMembers;
	
	
}
