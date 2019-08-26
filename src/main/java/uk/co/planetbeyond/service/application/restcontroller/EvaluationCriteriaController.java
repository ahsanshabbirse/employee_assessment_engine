package uk.co.planetbeyond.service.application.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.bcel.classfile.Constant;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.co.planetbeyond.service.application.constants.Constants;
import uk.co.planetbeyond.service.application.constants.Messages;
import uk.co.planetbeyond.service.application.generated.bean.Department;
import uk.co.planetbeyond.service.application.generated.bean.Employee;
import uk.co.planetbeyond.service.application.generated.bean.EvaluationCriteria;
import uk.co.planetbeyond.service.application.generated.bean.EvaluationParameter;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.EvaluationCriteriaBean;
import uk.co.planetbeyond.service.application.response.bean.EvaluationParameterBean;
import uk.co.planetbeyond.service.application.session.manager.Manager;

@RestController
@RequestMapping(value = "evaluation_criteria", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class EvaluationCriteriaController extends RestServiceController
{
	@GetMapping(value = "/{departmentId}")
	private ResponseEntity<String> getCriteriaList(@PathVariable(required = true) int departmentId) throws IOException
	{
		log.info("---> Request: Going to Provide List of Criteria Data");
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<EvaluationCriteria> query = session.createQuery("FROM EvaluationCriteria WHERE department_id=:departmentId");
			query.setParameter("departmentId", departmentId);

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<EvaluationCriteria> criteriaList = query.getResultList();

				List<EvaluationCriteriaBean> evaluatioonCriteriaBeanList = new ArrayList<EvaluationCriteriaBean>();

				for (EvaluationCriteria critera : criteriaList)
				{
					EvaluationCriteriaBean evaluationCriteriaBean = service.serializeEvaluationCriteriaData(critera);
					evaluatioonCriteriaBeanList.add(evaluationCriteriaBean);
				}
				System.out.println(evaluatioonCriteriaBeanList.toString());

				DataBean dataBean = new DataBean();
				dataBean.setEvaluationCriteriaList(evaluatioonCriteriaBeanList);

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
	
	@PostMapping(value = "/update_evaluation_status")
	private ResponseEntity<String> updateEvaluationStatusForEmployeeAndDepartment(@RequestBody(required = true) Department departmentBean) throws IOException
	{
		log.info("---> Request: Going to Update evaluation status for employee and department");
		try
		{
			if(departmentBean.isEvaluationStatus()) {
				departmentBean.setEvaluationStartTimestamp(new Date());
			}
			else {
				departmentBean.setEvaluationEndTimestamp(new Date());
			}
			session = Manager.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.update(departmentBean);
//			Query<Department> departmentUpdateQuery = session.createQuery("UPDATE Department SET evaluation_status=:evaluationStatus WHERE department_id=:departmentId");
//			departmentUpdateQuery.setParameter("evaluationStatus", departmentBean.isEvaluationStatus());
//			departmentUpdateQuery.setParameter("departmentId", departmentBean.getDepartmentId());
			
			
			Query<Employee> employeeUpdateQuery = session.createQuery("UPDATE Employee SET evaluation_status=:evaluationStatus WHERE department_id=:departmentId AND ex_employee=:exEmployee");
			employeeUpdateQuery.setParameter("evaluationStatus", departmentBean.isEvaluationStatus());
			employeeUpdateQuery.setParameter("departmentId", departmentBean.getDepartmentId());
			employeeUpdateQuery.setParameter("exEmployee", Constants.get().EMPLOYEE_STATUS_ACTIVE);

//			int departmentUpdateResult = departmentUpdateQuery.executeUpdate();
			int employeeUpdateResult = employeeUpdateQuery.executeUpdate();
			tx.commit();
			if (employeeUpdateResult !=0)
			{
				response = utils.createResponse(Messages.get().RECORD_UPDATE_SUCCESSFUL_MESSAGE);
			}
			else
			{
				response = utils.createResponse(Messages.get().RECORD_UPDATE_FAILED_MESSAGE);

			}


		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_UPDATE_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}

		return response;
	}
	
	
	@PostMapping()
	private ResponseEntity<String> createEvaluationCriteria(@Valid @RequestBody EvaluationCriteria evaluationCriteria) throws IOException
	{

		log.info("---> Request: Going to Insert Evaluation Criteria Data: " + evaluationCriteria.toString());
		try
		{
			session = Manager.getSessionFactory().openSession();
			tx = session.beginTransaction();

			evaluationCriteria.setCreatedTimestamp(new Date());
			session.save(evaluationCriteria);

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
	
	@PostMapping(value = "/update_evaluation_criteria_bean")
	private ResponseEntity<String> updateEvaluationBean(@Valid @RequestBody EvaluationCriteria evaluationCriteria) throws IOException
	{

		log.info("---> Request: Going to update Evaluation Criteria Data: " + evaluationCriteria.toString());
		try
		{
			session = Manager.getSessionFactory().openSession();
			tx = session.beginTransaction();

			evaluationCriteria.setCreatedTimestamp(new Date());
			session.update(evaluationCriteria);

			tx.commit();

			response = utils.createResponse(null, Messages.get().RECORD_UPDATE_SUCCESSFUL_MESSAGE);
		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_UPDATE_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}
	
		

		return response;
	}
	
	
	@DeleteMapping(value = "/{criteriaId}")
	private ResponseEntity<String> deleteCriteria(@PathVariable(required = true) int criteriaId) throws IOException
	{
		log.info("---> Request: Going to Delete Criteria Data against id:"+ criteriaId);
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<EvaluationCriteria> query = session.createQuery("delete from EvaluationCriteria where evaluation_criteria_id=:criteriaId");
			query.setParameter("criteriaId", criteriaId);

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_NOT_FOUND);
			}
			else
			{
				

				response = utils.createResponse(Messages.get().RECORD_DELETE_SUCCESSFUL_MESSAGE);

			}

		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_DELETE_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}

		return response;
	}

}
