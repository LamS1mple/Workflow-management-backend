package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
@PrimaryKeyJoinColumn(name = "id_task")
public class Task extends Post{


	@Column
	private Date dateFinish;
	
	@Column
	private String title;
	@JsonIgnore
	@OneToMany(mappedBy = "task")
	private List<TaskMember> listTaskMember;
	
}
