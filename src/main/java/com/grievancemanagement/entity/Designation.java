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
public class Designation {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String name;
	
	@OneToMany(mappedBy = "designation")
	private List<User> user = new ArrayList<>();
}
