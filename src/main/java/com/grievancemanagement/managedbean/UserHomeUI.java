package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.User;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager=true,name="userHomeUI")
public class UserHomeUI {
	
	@EJB
	private UserRepository userRepository;
	
	 @ManagedProperty(value = "#{authenticationBean}")
	 @Getter 
	 @Setter
	 private AuthenticationBean authenticationBean;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	public void makeAdmin() {
		authenticationBean.makeAdmin();
	}
	
}


