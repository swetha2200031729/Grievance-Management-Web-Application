package com.grievancemanagement.dao;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.grievancemanagement.entity.User;

@Stateless
public class UserRepository extends BaseRepository<User>{

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "User";
	}
	
	public User findByUsername(String username) {
		Query query = entityManager.createQuery("from " + getEntityName() + " where username=:username");
		query.setParameter("username", username);
		User user = (User) query.getSingleResult();
		return user;
	}
	
}
