package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.grievancemanagement.dao.CategoryRepository;
import com.grievancemanagement.dao.DepartmentRepository;
import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.entity.Category;
import com.grievancemanagement.entity.Department;
import com.grievancemanagement.entity.Grievance;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager=true, name="addGrievanceUI")
public class AddGrievanceUI {
	
	@EJB 
	private GrievanceRepository grievanceRepository;
	
	@EJB 
	private DepartmentRepository departmentRepository;
	
	@EJB
	private CategoryRepository categoryRepository;
	
	@ManagedProperty(value = "#{authenticationBean}")
	@Getter
	@Setter
	private AuthenticationBean authenticationBean;
	
	@Setter
	@Getter
	private String issue;
	
	@Setter
	@Getter
	private long departmentId;
	
	@Setter
	@Getter
	private long categoryId;
	
	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}
	
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
	public void addGrievance() {
		Department department = departmentRepository.findById(departmentId);
		Category category = categoryRepository.findById(categoryId);
		Grievance grievance = new Grievance();
		grievance.setIssue(issue);
		grievance.setDepartment(department);
		grievance.setUser(authenticationBean.getUser());
		grievance.setCategory(category);
		grievanceRepository.save(grievance);
	}
	
}
