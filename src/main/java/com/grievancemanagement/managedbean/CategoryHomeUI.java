package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.CategoryRepository;
import com.grievancemanagement.entity.Category;

@ManagedBean(eager=true,name="categoryHomeUI")
public class CategoryHomeUI {
	
	@EJB
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategories() {		
		return categoryRepository.findAll();
	}
	
	public void delete(long id) {
	   categoryRepository.deleteById(id);
	}
	
}
