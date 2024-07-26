package com.grievancemanagement.managedbean;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.grievancemanagement.dao.GrievanceReplyRepository;
import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.Grievance;
import com.grievancemanagement.entity.GrievanceReply;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name="addGrievanceReplyUI",eager=true)
public class AddGrievanceReplyUI {
	
	@Setter
	@Getter
	private long grievanceReplyId;
	
	@Setter
	@Getter
	private String reply;
	
	@Setter
	@Getter
	private LocalDateTime repliedAt;
	
	@Setter
	@Getter
	private String repliedBy;
	
	@EJB
	private GrievanceReplyRepository grievanceReplyRepository;
	
	@EJB
	private GrievanceRepository grievanceRepository;
	
	@EJB
	private UserRepository userRepository;
	
	@ManagedProperty(value = "#{authenticationBean}")
	@Getter
	@Setter
	private AuthenticationBean authenticationBean;
	
	public List<GrievanceReply> getGrievance(){
		return grievanceReplyRepository.findAll();
	}
	
	public String save() {
		Grievance grievance = grievanceRepository.findById(grievanceReplyId);
		GrievanceReply grievanceReply = new GrievanceReply();
		grievanceReply.setReply(reply);
		grievanceReply.setRepliedAt(repliedAt);
		grievanceReply.setRepliedBy(authenticationBean.getUser());
		grievanceReply.setGrievance(grievance);
		grievanceReplyRepository.save(grievanceReply);
		return "userGrievances.jsf?faces-redirect=true";
	}
	
}

