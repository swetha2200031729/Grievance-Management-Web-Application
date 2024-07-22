package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.DepartmentRepository;
import com.grievancemanagement.entity.Department;

@ManagedBean(eager=true,name="departmentHomeUI")
public class DepartmentHomeUI {

	@EJB
	private DepartmentRepository departmentRepository;
	
	public List<Department> getDepartments() {		
		return departmentRepository.findAll();
	}
	
	public void delete(long id) {
	   departmentRepository.deleteById(id);
	}

}