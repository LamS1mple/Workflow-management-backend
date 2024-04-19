package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity
public class Media {

	@Id
	@GeneratedValue
	private long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "taskmember_id")
	private TaskMember taskMember;
}
