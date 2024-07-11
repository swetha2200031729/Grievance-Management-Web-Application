package com.grievancemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TodoItem {

	@Id
	@GeneratedValue
	private int id;
	
	private String task;
	
}
