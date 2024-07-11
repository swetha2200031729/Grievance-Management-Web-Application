package com.grievancemanagement.dao;

import com.grievancemanagement.entity.Department;

public class DepartmentRepository extends BaseRepository<Department>{

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "Department";
	}

}
