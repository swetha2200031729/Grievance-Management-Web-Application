package com.grievancemanagement.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String name;
	
	@OneToMany(mappedBy = "department")
	private List<User> users = new ArrayList<>();
	
	@OneToMany(mappedBy = "department")
	private List<Grievance> grievances = new ArrayList<>();
	
}
