package uk.co.planetbeyond.service.application.session.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Manager
{
	private static SessionFactory sessionFactory;
	private static Logger log = LoggerFactory.getLogger(Manager.class);

	public static SessionFactory setupFactory()
	{
		try
		{
			sessionFactory = new Configuration()
					    .configure("hibernate.cfg.xml").buildSessionFactory();
			log.info("Information: Session Factory is Opened, " + sessionFactory.isOpen());
		}
		catch (Exception ex)
		{
			log.error(ex.toString(), ex);
		}
		return sessionFactory;
	}

	public static synchronized SessionFactory getSessionFactory()
	{
		if (sessionFactory == null || sessionFactory.isClosed())
		{
			sessionFactory = setupFactory();
		}
		return sessionFactory;
	}

	public static void endSession(Session session)
	{
		session.close();
		log.info("Information: Connection is Connected, " + session.isConnected());
		endSessionFactory();
	}

	private static void endSessionFactory()
	{
		sessionFactory.close();
		log.info("Information: Session Factory is Closed, " + sessionFactory.isClosed());
	}
}
