package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Post {

	@Id
	@GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date postDate;
	
	
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;
	
	@JsonIgnore
	@OneToMany(mappedBy = "post")
	private List<Media> listMedia;
	
}
