package com.grievancemanagement.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.User;

@ManagedBean(eager=true,name="userHomeUI")
public class UserHomeUI {
	
	@EJB
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public void delete(long id) {
		userRepository.deleteById(id);
	}
	
}


