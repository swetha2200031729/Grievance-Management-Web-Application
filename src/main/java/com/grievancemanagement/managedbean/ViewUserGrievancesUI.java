package com.grievancemanagement.managedbean;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.entity.Grievance;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager=true,name="viewUserGrievancesUI")
public class ViewUserGrievancesUI {
	
	@ManagedProperty(value = "#{authenticationBean}")
    @Getter @Setter
    private AuthenticationBean authenticationBean;
	
	@EJB
	private GrievanceRepository grievanceRepository;
	
	public List<Grievance> getUserGrievances() {
		List<Grievance> grievances = grievanceRepository.findByUser(authenticationBean.getUser());
		Collections.sort(grievances, (a, b) -> a.getCreatedAt().compareTo(b.getCreatedAt()));
		return grievances;
	}
	
}
