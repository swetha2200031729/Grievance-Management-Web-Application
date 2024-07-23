package com.grievancemanagement.managedbean;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.grievancemanagement.dao.DepartmentRepository;
import com.grievancemanagement.dao.DesignationRepository;
import com.grievancemanagement.dao.UserRepository;
import com.grievancemanagement.entity.Department;
import com.grievancemanagement.entity.Designation;
import com.grievancemanagement.entity.User;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(eager=true,name="addUserUI")
public class AddUserUI {

	@Getter
	@Setter
	private String firstName;
	
	@Getter
	@Setter
	private String lastName;
	
	@Getter
	@Setter
	private String dateOfBirth;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String contactNumber;
	
	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private long departmentId;
	
	@Getter
	@Setter
	private long designationId;
	
	@EJB
	private DepartmentRepository departmentRepository;
	
	@EJB
	private UserRepository userRepository;
	
	@EJB
	private DesignationRepository designationRepository;
	
	public List<Designation> getDesignations() {		
		return designationRepository.findAll();
	}
	
	public List<Department> getDepartments() {		
		return departmentRepository.findAll();
	}
	
	public void save() {
		
		Department department = departmentRepository.findById(departmentId);
		Designation designation = designationRepository.findById(designationId);
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(LocalDate.parse(dateOfBirth));
		user.setEmail(email);
		user.setContactNumber(contactNumber);
		user.setUsername(username);
		user.setPassword(password);
		user.setDepartment(department);
		user.setDesignation(designation);
		userRepository.save(user);
		
	}
	
}
