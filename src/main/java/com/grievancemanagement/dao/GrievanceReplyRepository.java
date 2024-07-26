package com.grievancemanagement.dao;

import javax.ejb.Stateless;

import com.grievancemanagement.entity.GrievanceReply;

@Stateless
public class GrievanceReplyRepository extends BaseRepository<GrievanceReply> {

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "GrievanceReply";
	}

}
