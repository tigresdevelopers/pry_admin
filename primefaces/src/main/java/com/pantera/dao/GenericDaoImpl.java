package com.pantera.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.transform.Transformers;

import com.pantera.util.HibernateUtil;
import com.pantera.util.JDBCRow;
import com.pantera.util.JDBCUtils;

public class GenericDaoImpl<T> implements GenericDao<T>{

	private Session session;
	private Transaction tran;
	
	
	
	public void persist(T entity){
	  session=HibernateUtil.getSessionFactory().openSession();
	  tran=session.beginTransaction();
		try {
			session.persist(entity);
			tran.commit();
			System.out.println("ok");
		} catch (HibernateException e) {
			tran.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public void save(T entity){
		  session=HibernateUtil.getSessionFactory().openSession();
		  tran=session.beginTransaction();
			try {
				session.save(entity);
				tran.commit();
			} catch (HibernateException e) {
				tran.rollback();
			}
		}
	
	public void update(T entity){
		  session=HibernateUtil.getSessionFactory().openSession();
		  tran=session.beginTransaction();
			try {
				session.update(entity);
				tran.commit();
			} catch (HibernateException e) {
				tran.rollback();
			}
		}
	
	public void saveOrUpdate(T entity){
		  session=HibernateUtil.getSessionFactory().openSession();
		  tran=session.beginTransaction();
			try {
				session.saveOrUpdate(entity);
				tran.commit();
			} catch (HibernateException e) {
				tran.rollback();
			}
		}
	
	public void delete(T entity){
		  session=HibernateUtil.getSessionFactory().openSession();
		  tran=session.beginTransaction();
			try {
				session.delete(entity);
				tran.commit();
			} catch (HibernateException e) {
				tran.rollback();
			}
		}
	
	@SuppressWarnings("unchecked")
	public T find(Class<T> entityClass,Serializable id){
		  session=HibernateUtil.getSessionFactory().openSession();
		  return (T) session.get(entityClass,id);
		}
	
	
	@SuppressWarnings("unchecked")
	public List<T> listAll(Class<T> entityClass){
		  session=HibernateUtil.getSessionFactory().openSession();
		  return session.createCriteria(entityClass).list();
		}
	
	
    public void saveCollection(List<T> object) throws Exception {
    	session=HibernateUtil.getSessionFactory().openSession();
        for (T model : object) {
        	session.save(model);
        }
    }
    
    @SuppressWarnings("unchecked")
	public T getByHQL(String hql, Map<String, Object> parameters, Class<T> type) {
    	session=HibernateUtil.getSessionFactory().openSession();
        Query que = session.createQuery(hql);
        if (parameters != null) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                que.setParameter(entry.getKey(), entry.getValue());
            }
        }
        if (type != null) {
            que.setResultTransformer(Transformers.aliasToBean(type));
        }
        T obj = (T) que.uniqueResult();
        Hibernate.initialize(obj);
        return obj;
    }
    
    public int executeQuery(String query, boolean nativeSQL) {
    	session=HibernateUtil.getSessionFactory().openSession();
        if (nativeSQL) {
            return session.createSQLQuery(query).executeUpdate();
        } else {
            return session.createQuery(query).executeUpdate();
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public List listHQL(String hql, Map<String, Object> parameters, Class clazz) {
    	session=HibernateUtil.getSessionFactory().openSession();
        Query query;
        if (clazz == null) {
            query =session.createQuery(hql);
        } else {
            query =session.createQuery(hql).setResultTransformer(Transformers.aliasToBean(clazz));
        }
        if (parameters != null) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.list();
    }
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public List listSQL(String sql, Map<String, Object> parameters, Class clazz) {
    	session=HibernateUtil.getSessionFactory().openSession();
        Query query;
        if (clazz == null) {
            query =session.createSQLQuery(sql);
        } else {
            query =session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(clazz));
        }
        if (parameters != null) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.list();
    }
    
    
    @SuppressWarnings("unchecked")
	@Override
    public List<T> listCriterion(Class<T> oClass,List<Criterion> listCriterion) {
    	session=HibernateUtil.getSessionFactory().openSession();
        Criteria criteria =session.createCriteria(oClass);
        for (int i = 0; i < listCriterion.size(); i++) {
            criteria.add(listCriterion.get(i));
        }
        return criteria.list();
    }
    
    
    @Override
    public void updateCollection(List<T> object) throws Exception {
    	session=HibernateUtil.getSessionFactory().openSession();
        for (T model : object) {
        	session.update(model);
        }
    }
    
    @Override
    public int executeQuery(String query, Map<String, Object> parameters, boolean nativeSQL) {
    	session=HibernateUtil.getSessionFactory().openSession();
        Query q;
        if (nativeSQL) {
            q = session.createSQLQuery(query);
        } else {
            q = session.createQuery(query);
        }
        if (parameters != null) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return q.executeUpdate();
    }
    
    
    @SuppressWarnings("deprecation")
	@Override
    public List<Map<Integer, Object>> return_cursor(Object[] params) throws Exception {
    	session=HibernateUtil.getSessionFactory().openSession();
        CallableStatement callstm = null;
        Transaction trans = session.beginTransaction();
        List<Map<Integer, Object>> rows = new ArrayList<Map<Integer, Object>>();
        try {
            callstm =HibernateUtil.getSessionFactory().openStatelessSession().connection().prepareCall("call ecprc_getcolorwaydetail(?, ?, ?, ?, ?)");
            callstm.setInt(1, (int) params[0]);
            callstm.setInt(2, (int) params[1]);
            callstm.setString(3, params[2].toString());
            callstm.setInt(4, (int) params[3]);
            callstm.registerOutParameter(5, OracleTypes.CURSOR);
            callstm.execute();

            ResultSet resultset = (ResultSet) callstm.getObject(5);

            ResultSetMetaData resultSetMetaData = resultset.getMetaData();

            while (resultset.next()) {
                
                Map<Integer, Object> fil = new HashMap<Integer, Object>();
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    int columnindex = i + 1;

                    JDBCRow row = new JDBCRow();
                    row.setFieldKey(resultSetMetaData.getColumnName(columnindex));
                    String columntype = resultSetMetaData.getColumnTypeName(columnindex);

                    if (JDBCUtils.fn_oColumnData(resultset, columntype, columnindex)!= null) 
                        row.setFieldValue(JDBCUtils.fn_oColumnData(resultset, columntype, columnindex));
                    
                    fil.put(i,row);
                }
                rows.add(fil);
            }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        trans.commit();

        return rows;
    }
}
