package uk.co.planetbeyond.service.application.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.planetbeyond.service.application.constants.Messages;
import uk.co.planetbeyond.service.application.generated.bean.EvaluationParameter;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.EvaluationParameterBean;
import uk.co.planetbeyond.service.application.session.manager.Manager;

@RestController
@RequestMapping(value = "evaluation_parameter", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class EvaluationParameterController extends RestServiceController
{
	@GetMapping()
	private ResponseEntity<String> getEvaluationParameters() throws IOException
	{
		log.info("---> Request: Going to Provide List of Evaluation Paramters");
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<EvaluationParameter> query = session.createQuery("FROM EvaluationParameter ORDER BY evaluationParameterId");

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<EvaluationParameter> evaluationParameterList = query.getResultList();

				List<EvaluationParameterBean> evaluationParameterBeanList = new ArrayList<>();

				for (EvaluationParameter evaluationParameter : evaluationParameterList)
				{
					EvaluationParameterBean evaluationParameterBean = service.serializeevaluationParameterData(evaluationParameter);
					evaluationParameterBeanList.add(evaluationParameterBean);
				}

				DataBean dataBean = new DataBean();
				dataBean.setEvaluationParameterBeanList(evaluationParameterBeanList);

				response = utils.createResponse(dataBean, Messages.get().RECORD_FOUND_SUCCESSFUL_MESSAGE);
			}

		}
		catch (HibernateException ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}

		return response;
	}

	@PostMapping()
	private ResponseEntity<String> createEvaluationParameter(@Valid @RequestBody EvaluationParameter evaluationParameter) throws IOException
	{

		log.info("---> Request: Going to Insert Evaluation Parameter Data: " + evaluationParameter.toString());
		try
		{
			session = Manager.getSessionFactory().openSession();
			tx = session.beginTransaction();

			evaluationParameter.setCreatedTimestamp(new Date());
			session.save(evaluationParameter);

			tx.commit();

			response = utils.createResponse(null, Messages.get().RECORD_INSERTED_SUCCESSFUL_MESSAGE);
		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_INSERTED_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}
	

		return response;
	}
}
