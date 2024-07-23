package com.grievancemanagement.dao;

import javax.ejb.Stateless;

import com.grievancemanagement.entity.Category;

@Stateless
public class CategoryRepository extends BaseRepository<Category> {

	@Override
	protected String getEntityName() {
		// TODO Auto-generated method stub
		return "Category";
	}
	
}
