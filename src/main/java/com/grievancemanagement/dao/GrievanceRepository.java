package com.grievancemanagement.dao;

import javax.ejb.Stateless;

import com.grievancemanagement.entity.Grievance;

@Stateless
public class GrievanceRepository extends BaseRepository<Grievance> {

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "Grievance";
	}

}
