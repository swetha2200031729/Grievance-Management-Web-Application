package com.grievancemanagement.export;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.entity.Grievance;
import com.grievancemanagement.entity.GrievanceReply;

@ManagedBean(name="grievanceExport",eager=true)
public class GrievanceExport extends BaseExport{

	@EJB
	private GrievanceRepository grievanceRepository;
	
	@Override
	protected String getCommaSeperatedData() {
		List<Grievance> grievances = grievanceRepository.findAll();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ID,Issue,User,Created At,Department,Category,Reply,Replied By, Replied At\n");
		
		for (Grievance grievance : grievances) {
			stringBuilder.append(String.format("%d,%s,%s,%s,%s,%s,\n", grievance.getId(), grievance.getIssue(), grievance.getUser().getUsername(), grievance.getCreatedAt(), grievance.getDepartment().getName(), grievance.getCategory().getName()));
			GrievanceReply reply = grievance.getGrievanceReply();
			if (reply == null) {
				stringBuilder.append(",,,");
			} else {
				stringBuilder.append(String.format("%s,%s,%s", reply.getReply(), reply.getRepliedBy().getUsername(), reply.getRepliedAt().toString()));
			}
			stringBuilder.append("\n");
		}
		
		return stringBuilder.toString();
	}

	@Override
	protected String getFileName() {
		return "grievances";
	}

}
