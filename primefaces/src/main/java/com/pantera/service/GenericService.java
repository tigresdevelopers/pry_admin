package com.pantera.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

public interface GenericService<T>{
	
	public void persist(T entity);
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void saveOrUpdate(T entity);
	
	public void delete(T entity);
	
	public T find(Class<T> entityClass,Serializable id);
	
	public List<T> listAll(Class<T> entityClass);
	
	/** Adicionales Para Analizar **/
	public void saveCollection(List<T> object) throws Exception;
	
	public T getByHQL(String hql, Map<String, Object> parameters, Class<T> type) throws Exception;
	
    public int executeQuery(String query, boolean nativeSQL) throws Exception;

    @SuppressWarnings("rawtypes")
	public List<T> listHQL(String hql, Map<String, Object> parameters, Class clazz) throws Exception;
    @SuppressWarnings("rawtypes")
	public List<T> listSQL(String sql, Map<String, Object> parameters, Class clazz) throws Exception;
    
    public List<T> listCriterion(Class<T> oClass,List<Criterion> listCriterion );
    
    public void updateCollection(List<T> object) throws Exception;
    
    public int executeQuery(String query, Map<String, Object> parameters, boolean nativeSQL);
    
    /** Cursores **/
    public List<Map<Integer, Object>> return_cursor(Object[] params) throws Exception;
}
