package com.grievancemanagement.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "loginUI")
@RequestScoped
public class LoginUI {
    
    @ManagedProperty(value = "#{authenticationBean}")
    @Getter @Setter
    private AuthenticationBean authenticationBean;
    
    @Getter @Setter
    private String username;
    
    @Getter @Setter
    private String password;
    
    public String login() {
        String cleanUsername = username.trim();
        if (cleanUsername.isEmpty() || password.isEmpty()) {
            return null;
        }
        
        authenticationBean.authenticate(cleanUsername, password);
        
        if (authenticationBean.isLoggedIn()) {
            return "index.jsf?faces-redirect=true";
        } else {
            return null; // stay on the same page or handle error as needed
        }
          
    }
}
