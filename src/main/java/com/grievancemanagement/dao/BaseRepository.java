package com.grievancemanagement.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public abstract class BaseRepository<T> {
	
	@PersistenceContext(unitName = "grievanceManagement")
	protected EntityManager entityManager;
    
	protected abstract String getEntityName();
	
	public void save(T obj) {
		entityManager.persist(obj);
	}
	
	public List<T> findAll() {
		Query query = entityManager.createQuery("from " + getEntityName());
		System.out.println(query);
		return query.getResultList();
	} 
	
	public void delete(T obj) {
		entityManager.remove(obj);
	}
	
	public void deleteById(long id) {
		delete(findById(id));
	}
	
	public T findById(long id){
		Query query = entityManager.createQuery("from " + getEntityName() + " where id = :id"); 
		query.setParameter("id", id);
		return (T) query.getResultList().get(0);
	}
	
	public void update(T obj) {
		entityManager.merge(obj);
	}
	
}
