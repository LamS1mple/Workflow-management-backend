package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.response.ApiResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity
public class TaskMember {

	@Id
	@GeneratedValue
	private long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateFinish;
	
	
	
	private boolean isFinish;
	
    private String contentTask;

	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "taskMember")
	private List<DetailTaskMember> listDetalDetailTaskMember;
	
	@JsonIgnore
	@OneToMany(mappedBy = "taskMember")
	private List<Media> listMedia;

	@JsonIgnore
	@OneToOne(mappedBy = "taskMember")
	private NoticeTask notice;

}
