package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "notice")
public class NoticeTask {
	
	@Id
	private long id;
	
	private String titleNotice;
	
	private String contentNotic;
	
	@OneToOne
	@JoinColumn(name = "taskmember_id")
	private TaskMember taskMember;
}
