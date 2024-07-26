package com.grievancemanagement.export;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.User;
@ManagedBean(eager=true,name="userExport")
public class UserExport extends BaseExport {
	
	@EJB
	private UserRepository userRepository;
	
	@Override
	protected String getCommaSeperatedData() {
		List<User> users = userRepository.findAll();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ID,UserName,FirstName,LastName,DateOfBirth,Email,Department,Designation\n");
		
		for (User user : users) {
			stringBuilder.append(String.format("%d,%s,%s,%s,%s,%s,%s,%s\n", user.getId(), user.getUsername(),user.getFirstName(),user.getLastName(),user.getDateOfBirth(),user.getEmail(),user.getDepartment().getName(),user.getDesignation().getName()));
		}
		
		return stringBuilder.toString();
		
		
	}

	@Override
	protected String getFileName() {
		return "Users";
	}

}
