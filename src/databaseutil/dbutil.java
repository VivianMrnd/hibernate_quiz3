package databaseutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Entity_hibernate.PersonDetail;
import Entity_hibernate.PersonDetail_onetomany;
import Entity_hibernate.barangay;
import Entity_hibernate.barangay_onetomany;


public class dbutil {

	private static SessionFactory factory;

	public static Session getSession() {
		factory = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(PersonDetail.class)
				.addAnnotatedClass(barangay.class)
				.addAnnotatedClass(PersonDetail_onetomany.class)
				.addAnnotatedClass(barangay_onetomany.class)
				.buildSessionFactory();
		
		return factory.openSession();
	}
	
}
