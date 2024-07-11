package com.grievancemanagement.dao;

import com.grievancemanagement.entity.Designation;

public class DesignationRepository extends BaseRepository<Designation>{

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "Designation";
	}

}
