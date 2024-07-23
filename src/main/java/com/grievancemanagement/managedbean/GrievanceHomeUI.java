package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.entity.Grievance;

@ManagedBean(eager=true,name="grievanceHomeUI")
public class GrievanceHomeUI {
	
	@EJB 
	private GrievanceRepository grievanceRepository;
	
	public List<Grievance> getGrievances() {		
		return grievanceRepository.findAll();
	}
	public void delete(long id) {
	   grievanceRepository.deleteById(id);
	}

}
