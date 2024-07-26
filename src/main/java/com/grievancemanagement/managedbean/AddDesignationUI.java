package com.grievancemanagement.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.DesignationRepository;
import com.grievancemanagement.entity.Designation;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager =true, name ="addDesignationUI")
public class AddDesignationUI {
	
	@Setter
	@Getter
	private String designationName;
	
	@EJB
	private DesignationRepository designationRepository;
	
	public String addDesignation() {
		Designation designation = new Designation();
		designation.setName(designationName);
		designationRepository.save(designation);
		return "adminDesignation.jsf?faces-redirect=true";
		
	}
	
}
