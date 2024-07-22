package com.grievancemanagement.dao;

import javax.ejb.Stateless;

import com.grievancemanagement.entity.Department;

@Stateless
public class DepartmentRepository extends BaseRepository<Department>{

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "Department";
	}

}
