package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUtils {
	private static SessionFactory sessionfactory;
	
	public static Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	public static SessionFactory getSessionFactory(){
        
		if(sessionfactory==null||sessionfactory.isClosed()){
			sessionfactory=new Configuration().configure().buildSessionFactory();
			
		}
		return sessionfactory;
		
	
	}
}
