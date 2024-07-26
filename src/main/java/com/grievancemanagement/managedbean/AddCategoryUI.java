package com.grievancemanagement.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.CategoryRepository;
import com.grievancemanagement.entity.Category;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager=true,name="addCategoryUI")
public class AddCategoryUI {
	
	@Setter
	@Getter
	private String categoryName;
	
	@EJB
	private CategoryRepository categoryRepository;
	
	public String addCategory() {
		
		Category category = new Category();
		category.setName(categoryName);
		categoryRepository.save(category);
		
		return "categoryHome.jsf?faces-redirect=true";
		
	}
	
}
