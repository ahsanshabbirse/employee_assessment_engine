package uk.co.planetbeyond.service.application.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uk.co.planetbeyond.service.application.constants.Messages;
import uk.co.planetbeyond.service.application.generated.bean.Employee;
import uk.co.planetbeyond.service.application.generated.bean.EmployeeEvaluation;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeeBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeeEvaluationBean;
import uk.co.planetbeyond.service.application.session.manager.Manager;

@RestController
@RequestMapping(value = "employee_evaluation", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class EmployeeEvaluationController extends RestServiceController
{
	@PostMapping()
	private ResponseEntity<String> addEvaluationRecord(@RequestBody EmployeeEvaluation evaluationListBean[]) throws IOException
	{
		log.info("---> Request: Going to Insert Employee evaluation complete Data: " + evaluationListBean);

		session = Manager.getSessionFactory().openSession();
		tx = session.beginTransaction();

		

			try
			{
				for(EmployeeEvaluation evaluationBean: evaluationListBean) {
					evaluationBean.setCreatedTimestamp(new Date());
				session.saveOrUpdate(evaluationBean);
				}
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
	
	
	@GetMapping()
	private ResponseEntity<String> getEmployeeEvaluation() throws IOException
	{
		log.info("---> Request: Going to Provide List of Employee Evaluation Data");
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<EmployeeEvaluation> query = session.createQuery("FROM EmployeeEvaluation");

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<EmployeeEvaluation> employeeList = query.getResultList();

				List<EmployeeEvaluationBean> employeeBeanList = new ArrayList<EmployeeEvaluationBean>();

				for (EmployeeEvaluation employee : employeeList)
				{
					EmployeeEvaluationBean employeeBean = service.serializeEmployeeEvaluationData(employee);
					employeeBeanList.add(employeeBean);
				}

				DataBean dataBean = new DataBean();
				dataBean.setEmployeeEvaluationBeanList(employeeBeanList);

				response = utils.createResponse(dataBean, Messages.get().RECORD_FOUND_SUCCESSFUL_MESSAGE);

			}

		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_SINGLE_FOUND_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}

		return response;
	}
	
	@GetMapping(value = "/get_employee_evaluation")
	private ResponseEntity<String> getManagers(@RequestParam(required = true) String evaluationStartDate,Integer employeeId) throws IOException
	{
		log.info("---> Request: Going to Provide List of Evaluation Data for Specific Employee:" + employeeId);
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<EmployeeEvaluation> query = session.createQuery("FROM EmployeeEvaluation WHERE employee_id=:employeeId and created_timestamp >DATE(:evaluationStartDate) ORDER BY employee_evaluation_id");
			query.setParameter("employeeId", employeeId);
			query.setParameter("evaluationStartDate",evaluationStartDate);
			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<EmployeeEvaluation> employeeEvaluationList = query.getResultList();

				List<EmployeeEvaluationBean> employeeEvaluationBeanList = new ArrayList<EmployeeEvaluationBean>();

				for (EmployeeEvaluation employeeEvaluation : employeeEvaluationList)
				{
					EmployeeEvaluationBean employeeEvaluationBean = service.serializeEmployeeEvaluationData(employeeEvaluation);
					employeeEvaluationBeanList.add(employeeEvaluationBean);
				}

				DataBean dataBean = new DataBean();
				dataBean.setEmployeeEvaluationBeanList(employeeEvaluationBeanList);

				response = utils.createResponse(dataBean, Messages.get().RECORD_FOUND_SUCCESSFUL_MESSAGE);

			}

		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_SINGLE_FOUND_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}

		return response;
	}
}
