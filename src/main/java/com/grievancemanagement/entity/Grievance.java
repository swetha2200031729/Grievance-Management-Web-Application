package com.grievancemanagement.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Grievance {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String issue;
	
	@ManyToOne
	private User user;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Category category;
	
	@OneToOne(mappedBy = "grievance", fetch = FetchType.EAGER)
	private GrievanceReply grievanceReply;
}
