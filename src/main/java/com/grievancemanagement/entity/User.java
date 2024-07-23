package com.grievancemanagement.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String contactNumber;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Designation designation;
	
	@OneToMany(mappedBy = "user")
	private List<Grievance> grievances;
	
}
