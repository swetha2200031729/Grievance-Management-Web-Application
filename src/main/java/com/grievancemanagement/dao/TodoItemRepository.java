package com.grievancemanagement.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.grievancemanagement.entity.TodoItem;

@Stateless
public class TodoItemRepository {
     
	@PersistenceContext(unitName = "grievanceManagement")
	private EntityManager entityManager;

	public void insert(TodoItem todoItem) {
		entityManager.persist(todoItem);
	}
	
}
