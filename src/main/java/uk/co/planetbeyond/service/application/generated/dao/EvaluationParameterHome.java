package uk.co.planetbeyond.service.application.generated.dao;
// Generated Aug 9, 2019 1:01:54 PM by Hibernate Tools 5.2.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.co.planetbeyond.service.application.generated.bean.EvaluationParameter;

/**
 * Home object for domain model class EvaluationParameter.
 * @see uk.co.planetbeyond.service.application.generated.dao.EvaluationParameter
 * @author Hibernate Tools
 */
@Stateless
public class EvaluationParameterHome
{

	private static final Log log = LogFactory.getLog(EvaluationParameterHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EvaluationParameter transientInstance)
	{
		log.debug("persisting EvaluationParameter instance");
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

	public void remove(EvaluationParameter persistentInstance)
	{
		log.debug("removing EvaluationParameter instance");
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

	public EvaluationParameter merge(EvaluationParameter detachedInstance)
	{
		log.debug("merging EvaluationParameter instance");
		try
		{
			EvaluationParameter result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		}
		catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public EvaluationParameter findById(Integer id)
	{
		log.debug("getting EvaluationParameter instance with id: " + id);
		try
		{
			EvaluationParameter instance = entityManager.find(EvaluationParameter.class, id);
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
