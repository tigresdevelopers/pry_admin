package com.tigers.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

public interface GenericDao<T> {
	
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
	
	 /**
     * Realiza Update a los campos que no sean entidades
     * @param query
     * @param nativeSQL
     * @return Numero de filas afectadas
     * @throws Exception 
     */
    public int executeQuery(String query, boolean nativeSQL) throws Exception;
    
    /**
     * Realiza Update a los campos que no sean entidades
     * @param hql
     * @param parameters
     * @param clazz
     * @return Numero de filas afectadas
     * @throws Exception 
     */
    
    @SuppressWarnings("rawtypes")
	public List<T> listHQL(String hql, Map<String, Object> parameters, Class clazz) throws Exception;
    @SuppressWarnings("rawtypes")
	public List<T> listSQL(String sql, Map<String, Object> parameters, Class clazz) throws Exception;
    
    /**
     * Se debe crear una lista de objetos Criterion de Hibernate: <ul>
     * <code>List(Criterion) listCriterion = new ArrayList();</code> Ejemplos:
     * </ul> <ul> <li> To get records having salary more than 2000 </li>
     * <code>listCriterion.add(Restrictions.gt("salary", 2000));</code>
     *
     * </ul> <ul><li>To get records having salary less than 2000</li>
     * <code>listCriterion.add(Restrictions.lt("salary", 2000));</code> </ul>
     * <ul> <li>To get records having fistName starting with zara</li>
     * <code>listCriterion.add(Restrictions.like("firstName", "zara%"));</code>
     * </ul> <ul> <li>Case sensitive form of the above restriction.</li>
     * <code>listCriterion.add(Restrictions.ilike("firstName", "zara%"));</code>
     * </ul> <ul> <li> To get records having salary in between 1000 and
     * 2000</li>
     * <code>listCriterion.add(Restrictions.between("salary", 1000, 2000));</code>
     * </ul> <ul> <li> To check if the given property is null</li>
     * <code>listCriterion.add(Restrictions.isNull("salary"));</code> </ul> <ul>
     * <li> To check if the given property is not null</li>
     * <code>listCriterion.add(Restrictions.isNotNull("salary"));</code> </ul>
     * <ul> <li> To check if the given property is empty</li>
     * <code>listCriterion.add(Restrictions.isEmpty("salary"));</code> </ul>
     * <ul> <li> To check if the given property is not empty</li>
     * <code>listCriterion.add(Restrictions.isNotEmpty("salary"));</code> </ul>
     *
     * @param listCriterion Lista de restricciones para realizar la consulta.
     * @return Retorna una lista con condiciones dadas.
     */
    public List<T> listCriterion(Class<T> oClass,List<Criterion> listCriterion );
    
    public void updateCollection(List<T> object) throws Exception;
    
    public int executeQuery(String query, Map<String, Object> parameters, boolean nativeSQL);
    
    /** Cursores **/
    public List<Map<Integer, Object>> return_cursor(Object[] params) throws Exception;
    

}
