package com.grievancemanagement.managedbean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.grievancemanagement.dao.GrievanceReplyRepository;
import com.grievancemanagement.dao.GrievanceRepository;
import com.grievancemanagement.entity.Grievance;
import com.grievancemanagement.entity.GrievanceReply;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "grievanceReplyBean", eager = true)
@ViewScoped
public class GrievanceReplyBean {

	@ManagedProperty(value = "#{authenticationBean}")
	@Getter
	@Setter
	private AuthenticationBean authenticationBean;

	@EJB
	private GrievanceRepository grievanceRepository;

	@EJB
	private GrievanceReplyRepository grievanceReplyRepository;

	@Setter
	@Getter
	private Grievance grievance;

	@Setter
	@Getter
	private Long grievanceId;

	@Setter
	@Getter
	private String replyText;

	@PostConstruct
	public void init() {
		String idString = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (idString != null) {
			grievanceId = Long.parseLong(idString);
			grievance = grievanceRepository.findById(grievanceId);
		}
	}

	public boolean isReplied() {
		return grievance.getGrievanceReply() != null;
	}

	public String saveReply() {
		GrievanceReply grievanceReply = new GrievanceReply();
		grievanceReply.setGrievance(grievance);
		grievanceReply.setReply(replyText);
		grievanceReply.setRepliedBy(authenticationBean.getUser());
		grievanceReplyRepository.save(grievanceReply);
		return "bodPanel.jsf?faces-redirect=true";
	}
}
