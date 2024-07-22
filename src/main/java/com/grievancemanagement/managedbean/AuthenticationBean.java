package com.grievancemanagement.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.User;

import lombok.Setter;

@ManagedBean(eager=true,name="authenticationBean")
@SessionScoped
public class AuthenticationBean {
	
	@Setter
	private Long userId;
	@EJB
	private UserRepository userRepository;
	
	public User getUser() {
		return userRepository.findById(userId) ;
	
	}
}
