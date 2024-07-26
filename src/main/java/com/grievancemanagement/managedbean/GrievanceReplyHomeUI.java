package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.GrievanceReplyRepository;
import com.grievancemanagement.entity.GrievanceReply;

@ManagedBean(eager=true,name = "grievanceReplyHomeUI")
public class GrievanceReplyHomeUI {
	
	@EJB
	private GrievanceReplyRepository grievanceReplyRepository;
	
	public List<GrievanceReply> getGrievanceReply(){
		return grievanceReplyRepository.findAll();
	}
	
	public void delete(long id) {
		grievanceReplyRepository.deleteById(id);
	}
	
}
