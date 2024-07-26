package com.grievancemanagement.dao;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.grievancemanagement.entity.Permission;

@Stateless
public class PermissionRepository extends BaseRepository<Permission>{

	@Override
	protected String getEntityName() {
		return "Permission";
	}
	public Permission findByName(String name) {
		Query query = entityManager.createQuery("from " + getEntityName() + " where name=:name");
		query.setParameter("name",name);
		Permission permission = (Permission) query.getSingleResult();
		return permission;
	}

}
