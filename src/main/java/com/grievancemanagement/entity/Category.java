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
@Setter
@Getter
public class Category {
	
	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	private String name;	
	
	@OneToMany(mappedBy = "category")
	private List<Grievance> grievances = new ArrayList<>();
	
}
