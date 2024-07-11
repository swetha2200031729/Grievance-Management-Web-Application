package com.grievancemanagement.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.TodoItemRepository;
import com.grievancemanagement.entity.TodoItem;

@ManagedBean(eager = true, name = "todoItemUI")
public class TodoItemUI {
	
	private String text;
	
	@EJB(mappedName = "java:global/Grievance-Managment-EP/TodoItemRepository!com.grievancemanagement.dao.TodoItemRepository")
	private TodoItemRepository todoItemRepository;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
    public void save() {
    	TodoItem todoItem = new TodoItem();
    	todoItem.setTask(text);
    	todoItemRepository.insert(todoItem);
    }
}
