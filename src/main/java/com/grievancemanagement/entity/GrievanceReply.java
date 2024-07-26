package com.grievancemanagement.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GrievanceReply {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private Grievance grievance;
	
	private String reply;
	
	private LocalDateTime repliedAt = LocalDateTime.now();
	
	@ManyToOne
	private User repliedBy;
	
	
}
