package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "Team")
public class Group {

	@Id
	@GeneratedValue
	private long id;
	
	private String nameGroup;
	
	private String passWordGroup;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "host_id")
	private User hostGroup;
	
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<GroupMember> listMembers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<Post> listPosts;
}
