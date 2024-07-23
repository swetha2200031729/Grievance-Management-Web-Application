package com.grievancemanagement.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.User;

import lombok.Setter;

@ManagedBean(name = "authenticationBean")
@SessionScoped
public class AuthenticationBean {
    
    @Setter
    private Long userId;
    
    @EJB
    private UserRepository userRepository;
    
    public void authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            setUserId(user.getId());
        } else {
            setUserId(null);
        }
    }
    
    public User getUser() {
        return userRepository.findById(userId);
    }
    
    public boolean isLoggedIn() {
        return userId != null;
    }
}
