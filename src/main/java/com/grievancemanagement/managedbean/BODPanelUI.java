package com.grievancemanagement.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.entity.Grievance;

@ManagedBean(eager=true, name="bodPanelUI")
public class BODPanelUI {

	@EJB
	private GrievanceRepository grievanceRepository;
	
	private List<Grievance> grievances = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		grievances = grievanceRepository.findAll();
	}
	
	public List<Grievance> getPendingGrievances() {
		return grievances.stream()
				.filter(grievance -> Objects.isNull(grievance.getGrievanceReply()))
				.sorted((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()))
				.collect(Collectors.toList());
	}
	
	public List<Grievance> getSolvedGrievances() {
		return grievances.stream()
				.filter(grievance -> Objects.nonNull(grievance.getGrievanceReply()))
				.sorted((a, b) -> b.getGrievanceReply().getRepliedAt().compareTo(a.getGrievanceReply().getRepliedAt()))
				.collect(Collectors.toList());
	}
	
}
