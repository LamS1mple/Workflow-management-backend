package com.example.demo.dto.request;


import java.util.Date;
import java.util.List;

import com.example.demo.model.DetailTaskMember;
import com.example.demo.model.Media;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class TaskMemberRequest {


	private long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateFinish;
	
	
	
	private boolean isFinish;
	
    private String contentTask;


	private Task task;

	private User user;
	
	private List<DetailTaskMember> listDetalDetailTaskMember;
	
	private List<Media> listMedia;

}
