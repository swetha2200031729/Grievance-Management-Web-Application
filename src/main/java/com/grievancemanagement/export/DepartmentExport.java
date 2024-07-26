package com.grievancemanagement.export;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.DepartmentRepository;
import com.grievancemanagement.entity.Department;

@ManagedBean(eager=true, name="departmentExport")
public class DepartmentExport extends BaseExport {
	
	@EJB
	private DepartmentRepository departmentRepository;

	@Override
	protected String getCommaSeperatedData() {
		List<Department> departments = departmentRepository.findAll();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ID,Name\n");
		
		for (Department department : departments) {
			stringBuilder.append(String.format("%d,%s\n", department.getId(), department.getName()));
		}
		
		return stringBuilder.toString();
	}

	@Override
	protected String getFileName() {
		return "depratments";
	}
	
}
