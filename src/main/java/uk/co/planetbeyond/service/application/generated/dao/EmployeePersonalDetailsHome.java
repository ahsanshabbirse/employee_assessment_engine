package uk.co.planetbeyond.service.application.generated.dao;
// Generated Aug 9, 2019 1:01:54 PM by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.co.planetbeyond.service.application.generated.bean.EmployeePersonalDetails;

/**
 * Home object for domain model class EmployeePersonalDetails.
 * @see uk.co.planetbeyond.service.application.generated.dao.EmployeePersonalDetails
 * @author Hibernate Tools
 */
@Stateless
public class EmployeePersonalDetailsHome
{

	private static final Log log = LogFactory.getLog(EmployeePersonalDetailsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmployeePersonalDetails transientInstance)
	{
		log.debug("persisting EmployeePersonalDetails instance");
		try
		{
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		}
		catch (RuntimeException re)
		{
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EmployeePersonalDetails persistentInstance)
	{
		log.debug("removing EmployeePersonalDetails instance");
		try
		{
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		}
		catch (RuntimeException re)
		{
			log.error("remove failed", re);
			throw re;
		}
	}

	public EmployeePersonalDetails merge(EmployeePersonalDetails detachedInstance)
	{
		log.debug("merging EmployeePersonalDetails instance");
		try
		{
			EmployeePersonalDetails result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		}
		catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployeePersonalDetails findById(Integer id)
	{
		log.debug("getting EmployeePersonalDetails instance with id: " + id);
		try
		{
			EmployeePersonalDetails instance = entityManager.find(EmployeePersonalDetails.class, id);
			log.debug("get successful");
			return instance;
		}
		catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
}
