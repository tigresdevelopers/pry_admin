package com.tigers.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

import com.tigers.dao.GenericDao;
import com.tigers.dao.GenericDaoImpl;

public class GenericServiceImpl<T> implements GenericService<T>{
	
	GenericDao<T> dao=new GenericDaoImpl<T>();

	@Override
	public void persist(T entity) {
		dao.persist(entity);
	}

	@Override
	public void save(T entity) {
		dao.save(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		dao.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public T find(Class<T> entityClass, Serializable id) {
		return dao.find(entityClass, id);
	}

	@Override
	public List<T> listAll(Class<T> entityClass) {
		return dao.listAll(entityClass);
	}

	@Override
	public void saveCollection(List<T> object) throws Exception {
		dao.saveCollection(object);
	}

	@Override
	public T getByHQL(String hql, Map<String, Object> parameters, Class<T> type)throws Exception {
		return dao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		return dao.executeQuery(query, nativeSQL);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<T> listHQL(String hql, Map<String, Object> parameters,Class clazz) throws Exception {
		return dao.listHQL(hql, parameters, clazz);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<T> listSQL(String sql, Map<String, Object> parameters,Class clazz) throws Exception {
		return dao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List<T> listCriterion(Class<T> oClass, List<Criterion> listCriterion) {
		return dao.listCriterion(oClass, listCriterion);
	}

	@Override
	public void updateCollection(List<T> object) throws Exception {
		dao.updateCollection(object);
	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,boolean nativeSQL) {
		return dao.executeQuery(query,parameters, nativeSQL);
	}

	@Override
	public List<Map<Integer, Object>> return_cursor(Object[] params) throws Exception {
		return dao.return_cursor(params);
	}

	
}
