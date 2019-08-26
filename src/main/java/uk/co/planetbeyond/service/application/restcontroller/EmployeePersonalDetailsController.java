package uk.co.planetbeyond.service.application.restcontroller;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import javax.validation.Valid;

import org.hibernate.HibernateException;
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

import antlr.StringUtils;
import uk.co.planetbeyond.service.application.constants.Messages;
import uk.co.planetbeyond.service.application.generated.bean.EmployeePersonalDetails;
import uk.co.planetbeyond.service.application.generated.bean.Login;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeeBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeePersonalDetailsBean;
import uk.co.planetbeyond.service.application.session.manager.Manager;
import uk.co.planetbeyond.service.application.util.Utils;

@RestController
@RequestMapping(value = "employee_personal_details", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class EmployeePersonalDetailsController extends RestServiceController
{
	@GetMapping(value = "/{employeePersonalDetailsId}")
	private ResponseEntity<String> getPersonalDetails(@PathVariable(required = true) int employeePersonalDetailsId) throws IOException
	{

		log.info("---> Request: Going to Provide Employee Personal Details Data Against Requested ID = " + employeePersonalDetailsId);
		try
		{
			session = Manager.getSessionFactory().openSession();

			EmployeePersonalDetails employeePersonalDetails = session.get(EmployeePersonalDetails.class, employeePersonalDetailsId);

			if (employeePersonalDetails == null)
			{
				response = utils.createResponse(Messages.get().RECORD_SINGLE_FOUND_FAILED_MESSAGE);
			}
			else
			{
				EmployeePersonalDetailsBean employeePersonalDetailsBean = service.serializeEmployeePersonalDetailsData(employeePersonalDetails);

				DataBean dataBean = new DataBean();
				dataBean.setEmployeePersonalDetailsBean(employeePersonalDetailsBean);

				response = utils.createResponse(dataBean, Messages.get().RECORD_FOUND_SUCCESSFUL_MESSAGE);
			}

		}
		catch (HibernateException ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_SINGLE_FOUND_FAILED_MESSAGE);
		}
		finally
		{
			Manager.endSession(session);
		}

		return response;
	}
	
	@PutMapping(value = "/{employeePersonalDetailsId}")
	private ResponseEntity<String> updateEmployeePersonalDetail(@PathVariable(required = true) int employeePersonalDetailsId,@Valid @RequestBody EmployeePersonalDetails employeePersonalDetailBean) throws IOException
	{
		log.info("---> Request: Going to Update Employee personal Data against ID: " + employeePersonalDetailBean.getEmployeePersonalDetailsId());

		session = Manager.getSessionFactory().openSession();

		try
		{
				employeePersonalDetailBean.setCreatedTimestamp(new Date());
				tx = session.beginTransaction();
				session.update(employeePersonalDetailBean);

				tx.commit();
				
				EmployeePersonalDetailsBean employeePersonalDetail = service.serializeEmployeePersonalDetailsData(employeePersonalDetailBean);

				DataBean dataBean = new DataBean();
				dataBean.setEmployeePersonalDetailsBean(employeePersonalDetail);

				response = utils.createResponse(dataBean, Messages.get().RECORD_UPDATE_SUCCESSFUL_MESSAGE);
			
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

	
	@PostMapping(value = "/upload_image/{employeePersonalDetailsId}")
	private ResponseEntity<String> uploadProfileImage(@RequestParam("file") MultipartFile file,@PathVariable int employeePersonalDetailsId) throws IOException
	{
		log.info("---> Request: Going to Update Employee personal Data against ID: " + employeePersonalDetailsId);

		session = Manager.getSessionFactory().openSession();

		try
		{
			byte[] bytes = file.getBytes();
			String base64File = "";
			base64File = Base64.getEncoder().encodeToString(bytes);
			
			log.info("---> Request: base 64 " + base64File);

			
			EmployeePersonalDetails employeePersonalDetails = session.get(EmployeePersonalDetails.class, employeePersonalDetailsId);

			if (employeePersonalDetails == null)
			{
				return	response = utils.createResponse(Messages.get().RECORD_SINGLE_FOUND_FAILED_MESSAGE);
			}
		
		
			employeePersonalDetails.setPicture(bytes);
		
				tx = session.beginTransaction();
				session.update(employeePersonalDetails);

				tx.commit();

				EmployeePersonalDetailsBean employeePersonalDetailBean = service.serializeEmployeePersonalDetailsData(employeePersonalDetails);

				DataBean dataBean = new DataBean();
				dataBean.setEmployeePersonalDetailsBean(employeePersonalDetailBean);

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
