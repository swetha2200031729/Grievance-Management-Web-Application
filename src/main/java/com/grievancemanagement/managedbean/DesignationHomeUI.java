package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.DesignationRepository;
import com.grievancemanagement.entity.Designation;


@ManagedBean(eager=true, name="designationHomeUI")
public class DesignationHomeUI {
	
	
	@EJB
	private DesignationRepository designationRepository;
	
	public List<Designation> getDesignations() {		
		return designationRepository.findAll();
	}
	public void delete(long id) {
	   designationRepository.deleteById(id);
	}

    
	
}
