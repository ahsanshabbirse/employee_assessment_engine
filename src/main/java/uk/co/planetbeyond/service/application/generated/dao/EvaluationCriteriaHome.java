package uk.co.planetbeyond.service.application.generated.dao;
// Generated Aug 9, 2019 1:01:54 PM by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.co.planetbeyond.service.application.generated.bean.EvaluationCriteria;

/**
 * Home object for domain model class EvaluationCriteria.
 * @see uk.co.planetbeyond.service.application.generated.dao.EvaluationCriteria
 * @author Hibernate Tools
 */
@Stateless
public class EvaluationCriteriaHome
{

	private static final Log log = LogFactory.getLog(EvaluationCriteriaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EvaluationCriteria transientInstance)
	{
		log.debug("persisting EvaluationCriteria instance");
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

	public void remove(EvaluationCriteria persistentInstance)
	{
		log.debug("removing EvaluationCriteria instance");
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

	public EvaluationCriteria merge(EvaluationCriteria detachedInstance)
	{
		log.debug("merging EvaluationCriteria instance");
		try
		{
			EvaluationCriteria result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		}
		catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public EvaluationCriteria findById(Integer id)
	{
		log.debug("getting EvaluationCriteria instance with id: " + id);
		try
		{
			EvaluationCriteria instance = entityManager.find(EvaluationCriteria.class, id);
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
