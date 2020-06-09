package annotation.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import annotation.entity.PersonDetail;

public class dbutil {
	
	private static SessionFactory factory;

	public static Session getSession() {
		factory = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(PersonDetail.class)
				.buildSessionFactory();
		
		return factory.openSession();
	}
}
