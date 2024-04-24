package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@PrimaryKeyJoinColumn(name = "id_task")
public class Task extends Post{

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column
	private Date dateFinish;
	
	@JsonProperty("title")
	@Column
	private String title;
	@JsonIgnore
	@OneToMany(mappedBy = "task")
	private List<TaskMember> listTaskMember;
	public Date getDateFinish() {
		return dateFinish;
	}
	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<TaskMember> getListTaskMember() {
		return listTaskMember;
	}
	public void setListTaskMember(List<TaskMember> listTaskMember) {
		this.listTaskMember = listTaskMember;
	}
	
	
	
}
