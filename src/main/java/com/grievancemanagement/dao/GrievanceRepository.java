package com.grievancemanagement.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.grievancemanagement.entity.Department;
import com.grievancemanagement.entity.Grievance;
import com.grievancemanagement.entity.User;

@Stateless
public class GrievanceRepository extends BaseRepository<Grievance> {

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "Grievance";
	}
	
	public List<Grievance> findByUser(User user) {
		Query query = entityManager.createQuery("from " + getEntityName() + " where user=:user");
		query.setParameter("user", user);
		return (List<Grievance>) query.getResultList();
	}
	
	public List<Grievance> findByDepartment(Department department) {
		Query query = entityManager.createQuery("from " + getEntityName() + " where department=:department");
		query.setParameter("department", department);
		return (List<Grievance>) query.getResultList();
	}
	
}
