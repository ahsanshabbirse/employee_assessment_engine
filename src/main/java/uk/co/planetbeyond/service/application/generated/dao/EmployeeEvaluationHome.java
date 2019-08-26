package uk.co.planetbeyond.service.application.generated.dao;
// Generated Aug 9, 2019 1:01:54 PM by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.co.planetbeyond.service.application.generated.bean.EmployeeEvaluation;

/**
 * Home object for domain model class EmployeeEvaluation.
 * @see uk.co.planetbeyond.service.application.generated.dao.EmployeeEvaluation
 * @author Hibernate Tools
 */
@Stateless
public class EmployeeEvaluationHome
{

	private static final Log log = LogFactory.getLog(EmployeeEvaluationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmployeeEvaluation transientInstance)
	{
		log.debug("persisting EmployeeEvaluation instance");
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

	public void remove(EmployeeEvaluation persistentInstance)
	{
		log.debug("removing EmployeeEvaluation instance");
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

	public EmployeeEvaluation merge(EmployeeEvaluation detachedInstance)
	{
		log.debug("merging EmployeeEvaluation instance");
		try
		{
			EmployeeEvaluation result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		}
		catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployeeEvaluation findById(Integer id)
	{
		log.debug("getting EmployeeEvaluation instance with id: " + id);
		try
		{
			EmployeeEvaluation instance = entityManager.find(EmployeeEvaluation.class, id);
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
