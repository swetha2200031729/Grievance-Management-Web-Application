package com.grievancemanagement.dao;

import javax.ejb.Stateless;

import com.grievancemanagement.entity.Designation;
@Stateless
public class DesignationRepository extends BaseRepository<Designation>{

	@Override
	protected String getEntityName() {
		return "Designation";
	}

}
