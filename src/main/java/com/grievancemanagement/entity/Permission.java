package com.grievancemanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Permission {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_permission",joinColumns = @JoinColumn(name="permission_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> users = new ArrayList<>();
	
}
