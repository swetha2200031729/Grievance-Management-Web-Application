package com.grievancemanagement.managedbean;

import java.util.Objects;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.grievancemanagement.dao.PermissionRepository;
import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.Permission;
import com.grievancemanagement.entity.User;

import lombok.Setter;

@ManagedBean(name = "authenticationBean")
@SessionScoped
public class AuthenticationBean {
    
    @Setter
    private Long userId;
    
    @EJB
    private UserRepository userRepository;
    
    @EJB
    private PermissionRepository permissionRepository;
    
    public void authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            setUserId(user.getId());
        } else {
            setUserId(null);
        }
    }
    
    public User getUser() {
    	try{
    		return userRepository.findById(userId);
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    public boolean isLoggedIn() {
        return userId != null;
    }
    public String logout() {
    	userId = null;
    	return "login.jsf?faces-redirect=true";
    }
    public boolean isAdmin() {
    	
    	User user = getUser();
    	if(Objects.isNull(user)) {
    		return false;
    	}
    	boolean isAdminPermissionFound = user.getPermissions().stream()
    			.anyMatch(permission -> permission.getName().equals("ADMIN"));
    	return isAdminPermissionFound;
    	
    }
    
    public boolean isBoardOfDirector() {
    	
    	User user = getUser();
    	if(Objects.isNull(user)) {
    		return false;
    	}
    	boolean isAdminPermissionFound = user.getPermissions().stream()
    			.anyMatch(permission -> permission.getName().equals("BOD"));
    	return isAdminPermissionFound;
    	
    }
    
    public void makeAdmin() {
    	User user = getUser();
    	Permission permission = permissionRepository.findByName("ADMIN");
    	if(!isAdmin()) {
    		user.getPermissions().add(permission);
    		userRepository.save(user);
    	}
    }
}
