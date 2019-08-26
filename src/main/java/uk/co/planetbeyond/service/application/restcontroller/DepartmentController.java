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
import org.springframework.web.bind.annotation.RestController;

import uk.co.planetbeyond.service.application.constants.Messages;
import uk.co.planetbeyond.service.application.generated.bean.Department;
import uk.co.planetbeyond.service.application.generated.bean.Employee;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.DepartmentBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeeBean;
import uk.co.planetbeyond.service.application.session.manager.Manager;

@RestController
@RequestMapping(value = "department", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class DepartmentController extends RestServiceController
{
	@GetMapping(value = "/{departmentId}")
	private ResponseEntity<String> getDepartment(@PathVariable(required = true) int departmentId) throws IOException
	{

		log.info("---> Request: Going to Provide Department Data Against Requested ID = " + departmentId);
		try
		{
			session = Manager.getSessionFactory().openSession();

			Department department = session.get(Department.class, departmentId);

			if (department == null)
			{
				response = utils.createResponse(Messages.get().RECORD_SINGLE_FOUND_FAILED_MESSAGE);
			}
			else
			{
				DepartmentBean departmentBean = service.serializeDepartmentData(department);

				DataBean dataBean = new DataBean();
				dataBean.setDepartmentBean(departmentBean);

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
	private ResponseEntity<String> getListOfDepartments() throws IOException
	{
		log.info("---> Request: Going to Provide List of Departments Data");
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<Department> query = session.createQuery("FROM Department ORDER BY departmentId");

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<Department> departmentList = query.getResultList();

				List<DepartmentBean> departmentBeanList = new ArrayList<DepartmentBean>();

				for (Department department : departmentList)
				{
					DepartmentBean departmentBean = service.serializeDepartmentData(department);
					departmentBeanList.add(departmentBean);
				}

				DataBean dataBean = new DataBean();
				dataBean.setDepartmentBeanList(departmentBeanList);

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
	private ResponseEntity<String> createDepartment(@Valid @RequestBody Department department) throws IOException
	{

		log.info("---> Request: Going to Insert Department Data: " + department.toString());
		try
		{
			session = Manager.getSessionFactory().openSession();
			tx = session.beginTransaction();

			department.setCreatedTimestamp(new Date());
			session.save(department);

			tx.commit();

			DepartmentBean departmentBean = service.serializeDepartmentData(department);

			DataBean dataBean = new DataBean();
			dataBean.setDepartmentBean(departmentBean);

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

		return response;
	}
}
