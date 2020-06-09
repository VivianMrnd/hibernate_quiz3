package map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class dbutil {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static Session getSession() {

		Configuration config = new Configuration();
		config.configure();
		config.addResource("map/PersonDetail.hbm.xml");
		config.addResource("map/barangay.hbm.xml");

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		factory = config.buildSessionFactory(serviceRegistry);

		return factory.openSession();
	}
}
