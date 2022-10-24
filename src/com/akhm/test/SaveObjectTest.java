package com.akhm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.akhm.model.StudentModel;
public class SaveObjectTest {
	
	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction tx=null;
	    cfg=new Configuration();
		cfg=cfg.configure("com/akhm/conf/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		session=factory.openSession();
		
		StudentModel model=new StudentModel();
		model.setId(1);
		model.setFristName("Praveen");
		model.setLastName("Pusthela");
		
		try {
			
			tx=session.beginTransaction();
			session.save(model);
			tx.commit();
			System.out.println("Object Is inserted");
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			
		}
		session.close();
		factory.close();
		
		
		 
		
		
	}

}
