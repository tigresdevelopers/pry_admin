package com.tigers.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;   

    static 
    { 
        try {
           //Crea la SessionFactory desde hibernate.cfg.xml
            Configuration configuration = new Configuration();
          //configuration.configure("hibernate.cfg.xml");
            configuration.configure();
            System.out.println("Hibernate Configuration loaded");
             
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");
             
            sessionFactory= configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Hibernate sessionfactory created");
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }  

    public static SessionFactory getSessionFactory() 
    { 
        return sessionFactory; 
    } 
	
    
    public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
	}

}
