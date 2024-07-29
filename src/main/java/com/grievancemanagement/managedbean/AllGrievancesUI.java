package com.grievancemanagement.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.grievancemanagement.dao.DepartmentRepository;
import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.entity.Department;
import com.grievancemanagement.entity.Grievance;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager=true,name="allGrievancesUI")
@ViewScoped
public class AllGrievancesUI {
	
	@EJB 
	private GrievanceRepository grievanceRepository;
	
	@EJB
	private DepartmentRepository departmentRepository;
	
	@Getter
	private List<Grievance> allGrievances;
	
	@Getter
	@Setter
	private List<Grievance> grievances;

	@Getter
	@Setter
	private List<Department> departments;
	
	@Getter
	@Setter
	private Long selectedDepartmentId;
	
	@PostConstruct
	public void init() {
		allGrievances = grievanceRepository.findAll();
		departments = departmentRepository.findAll();
		String idString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (idString == null) {
			grievances = new ArrayList<>(allGrievances);
		} else {
			grievances = allGrievances.stream().filter(grievance -> grievance.getDepartment().getId() == Long.parseLong(idString)).collect(Collectors.toList());
		}
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
	
	public String applyFilter(Long id) {
		return "allGrievances.jsf?id=" + id + "&faces-redirect=true";
	}
	
}
