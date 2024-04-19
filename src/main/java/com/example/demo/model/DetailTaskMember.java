package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DetailTaskMember {

	@Id
	@GeneratedValue
	private long id;
	
	private Date dateFinish;
	
	private String titleTask;
	
	private String contentTask;
	
	private boolean isFinish;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "taskmember_id")
	private TaskMember taskMember;
}
