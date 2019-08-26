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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import uk.co.planetbeyond.service.application.constants.Messages;
import uk.co.planetbeyond.service.application.generated.bean.Employee;
import uk.co.planetbeyond.service.application.generated.bean.EmployeePersonalDetails;
import uk.co.planetbeyond.service.application.generated.bean.Login;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeeBean;
import uk.co.planetbeyond.service.application.response.bean.LoginBean;
import uk.co.planetbeyond.service.application.session.manager.Manager;

@RestController
@RequestMapping(value = "employee", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class EmployeeController extends RestServiceController
{
	@GetMapping(value = "/{employeeId}")
	private ResponseEntity<String> getEmployee(@PathVariable(required = true) int employeeId) throws IOException
	{
		log.info("---> Request: Going to Provide Employee Data Against Requested ID = " + employeeId);
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<Employee> query = session.createQuery("FROM Employee WHERE employeeId = " + employeeId);

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_SINGLE_FOUND_FAILED_MESSAGE);
			}
			else
			{
				Employee employee = query.getSingleResult();

				// Serializing the fetched data from table bean
				EmployeeBean employeeBean = service.serializeEmployeeData(employee);

				DataBean dataBean = new DataBean();
				dataBean.setEmployeeBean(employeeBean);

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

	@GetMapping()
	private ResponseEntity<String> getEmployee() throws IOException
	{
		log.info("---> Request: Going to Provide List of Employee Data");
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<Employee> query = session.createQuery("FROM Employee ORDER BY employeeId");

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<Employee> employeeList = query.getResultList();

				List<EmployeeBean> employeeBeanList = new ArrayList<EmployeeBean>();

				for (Employee employee : employeeList)
				{
					EmployeeBean employeeBean = service.serializeEmployeeData(employee);
					employeeBeanList.add(employeeBean);
				}

				DataBean dataBean = new DataBean();
				dataBean.setEmployeeBeanList(employeeBeanList);

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
	
	
	@GetMapping(value = "/get_managers")
	private ResponseEntity<String> getManagers(@RequestParam(required = true) byte departmentId , byte level) throws IOException
	{
		log.info("---> Request: Going to Provide List of Managers Data for Specific Department");
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<Employee> query = session.createQuery("FROM Employee WHERE department_id=:departmentId and level=:level ORDER BY employeeId");
			query.setParameter("departmentId", departmentId);
			query.setParameter("level", level);
			
			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<Employee> employeeList = query.getResultList();

				List<EmployeeBean> employeeBeanList = new ArrayList<EmployeeBean>();

				for (Employee employee : employeeList)
				{
					EmployeeBean employeeBean = service.serializeEmployeeData(employee);
					employeeBeanList.add(employeeBean);
				}

				DataBean dataBean = new DataBean();
				dataBean.setEmployeeBeanList(employeeBeanList);

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

	@PostMapping()
	private ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee) throws IOException
	{
		log.info("---> Request: Going to Insert Employee Data: " + employee);

		session = Manager.getSessionFactory().openSession();
		tx = session.beginTransaction();

		EmployeePersonalDetails employeePersonalDetails = insertEmployeePersonalDetails(employee.getEmployeePersonalDetails());

		if (employeePersonalDetails.getEmployeePersonalDetailsId() != null)
		{
			try
			{

				employee.setEmployeePersonalDetails(employeePersonalDetails);
				employee.setCreatedTimestamp(new Date());
				session.save(employee);

				tx.commit();

				EmployeeBean employeeBean = service.serializeEmployeeData(employee);

				DataBean dataBean = new DataBean();
				dataBean.setEmployeeBean(employeeBean);

				response = utils.createResponse(dataBean, Messages.get().RECORD_INSERTED_SUCCESSFUL_MESSAGE);
			}
			catch (Exception ex)
			{
				response = utils.handleException(ex, tx, log, Messages.get().RECORD_INSERTED_FAILED_MESSAGE);
			}
			finally
			{
				Manager.endSession(session);
			}
		}
		else
		{
			response = utils.createResponse(Messages.get().RECORD_INSERTED_FAILED_MESSAGE);
		}

		return response;
	}
	
	@PutMapping()
	private ResponseEntity<String> updateEmployee(@Valid @RequestBody Employee employeeBean) throws IOException
	{
		log.info("---> Request: Going to Update Employee Data against ID: " + employeeBean.getEmployeeId());

		session = Manager.getSessionFactory().openSession();

		try
		{
		
				tx = session.beginTransaction();
				employeeBean.setCreatedTimestamp(new Date());
				session.update(employeeBean);

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

	

	private EmployeePersonalDetails insertEmployeePersonalDetails(@Valid EmployeePersonalDetails employeePersonalDetails) throws IOException
	{
		log.info("---> ---> Request (Nested): Going to Insert Employee Personal Details Data: " + employeePersonalDetails);
		try
		{
			

			employeePersonalDetails.setCreatedTimestamp(new Date());

			session.save(employeePersonalDetails);

			

			log.info("Employee Personal Details Data Inserted Against ID = " + employeePersonalDetails.getEmployeePersonalDetailsId());
		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_INSERTED_FAILED_MESSAGE);
			Manager.endSession(session);
		}

		return employeePersonalDetails;
	}
	

	
}
