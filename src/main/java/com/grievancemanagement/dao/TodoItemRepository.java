package com.grievancemanagement.dao;

import javax.ejb.Stateless;

import com.grievancemanagement.entity.TodoItem;

@Stateless
public class TodoItemRepository extends BaseRepository<TodoItem> {

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "TodoItem";
	}
     
	
	
}
