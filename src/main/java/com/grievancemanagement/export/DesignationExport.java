package com.grievancemanagement.export;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.DesignationRepository;
import com.grievancemanagement.entity.Designation;

@ManagedBean(eager=true,name="designationExport")
public class DesignationExport extends BaseExport {
	
	@EJB
	private DesignationRepository designationRepository;
	
	@Override
	protected String getCommaSeperatedData() {
		List<Designation> designations = designationRepository.findAll();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ID,Name\n");
		
		for (Designation designation : designations) {
			stringBuilder.append(String.format("%d,%s\n", designation.getId(), designation.getName()));
		}
		
		return stringBuilder.toString();
		
	}

	@Override
	protected String getFileName() {
		return "Designations";
	}

}
