package com.grievancemanagement.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.DepartmentRepository;
import com.grievancemanagement.entity.Department;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager=true,name="addDepartmentUI")
public class AddDepartmentUI {
	@Setter
	@Getter
	private String departmentName;
	
	@EJB
	private DepartmentRepository departmentRepository;
	
	public String addDepartment() {
		Department department = new Department();
		department.setName(departmentName);
		departmentRepository.save(department);
		return "departmentHome.jsf?faces-redirect=true";
	}
}
