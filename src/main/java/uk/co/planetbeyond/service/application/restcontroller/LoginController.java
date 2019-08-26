package uk.co.planetbeyond.service.application.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uk.co.planetbeyond.service.application.constants.Messages;
import uk.co.planetbeyond.service.application.generated.bean.Login;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.LoginBean;
import uk.co.planetbeyond.service.application.session.manager.Manager;
import uk.co.planetbeyond.service.application.util.Utils;

@RestController
@RequestMapping(value = "login", produces = { MediaType.APPLICATION_JSON_VALUE, "application/hal+json" })
public class LoginController extends RestServiceController
{
	@PostMapping(value = "/authenticate")
	private ResponseEntity<String> authenticateLogin(@RequestBody LoginBean loginBean) throws IOException
	{
		log.info("---> Request: Going to Authenticate User Login via POST Request");
		response = authenticate(loginBean.getUserName(), loginBean.getPassword());

		return response;
	}

	@GetMapping(value = "/authenticate")
	private ResponseEntity<String> authenticateLogin(@RequestParam(required = true) String user, String pass) throws IOException
	{
		log.info("---> Request: Going to Authenticate User Login via GET Request");
		response = authenticate(user, pass);

		return response;
	}

	private ResponseEntity<String> authenticate(String user, String pass) throws IOException
	{
		try
		{
			//converting password string into md5
//			pass=Utils.md5Encode(pass);
			
			
			session = Manager.getSessionFactory().openSession();

			Query<Login> query = session.createQuery("FROM Login WHERE userName = :userName AND password = :password");
			query.setParameter("userName", user);
			query.setParameter("password", pass);

			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_NOT_FOUND);
			}
			else
			{

				Login login = query.getSingleResult();

				// Serializing the fetched data from table bean
				LoginBean loginBean = service.serializeLoginData(login);

				DataBean dataBean = new DataBean();
				dataBean.setLoginBean(loginBean);

				response = utils.createResponse(dataBean, Messages.get().LOGIN_AUTHENTICATION_SUCCESSFULL);
			}

		}
		catch (Exception ex)
		{
			response = utils.handleException(ex, tx, log, Messages.get().LOGIN_AUTHENTICATION_FAILED);
		}
		finally
		{
			Manager.endSession(session);
		}

		return response;
	}

	@GetMapping()
	private ResponseEntity<String> getLogin() throws IOException
	{
		log.info("---> Request: Going to Provide List of Login Data");
		try
		{
			session = Manager.getSessionFactory().openSession();

			Query<Login> query = session.createQuery("FROM Login ORDER BY loginId");
			if (query.stream().count() == 0)
			{
				response = utils.createResponse(Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
			}
			else
			{
				List<Login> loginList = query.getResultList();

				List<LoginBean> loginBeanList = new ArrayList<LoginBean>();

				for (Login login : loginList)
				{
					LoginBean loginBean = new LoginBean();

					// Serializing the fetched data from table bean
					loginBean = service.serializeLoginData(login);
					loginBeanList.add(loginBean);
				}
				log.info("Setting Up Response");
				DataBean dataBean = new DataBean();
				dataBean.setLoginBeanList(loginBeanList);

				response = utils.createResponse(dataBean, Messages.get().RECORD_FOUND_SUCCESSFUL_MESSAGE);
				log.info("Resposnse Created");
			}

		}
		catch (Exception ex)
		{
			log.info("In Exception");
			response = utils.handleException(ex, tx, log, Messages.get().RECORD_LIST_FOUND_FAILED_MESSAGE);
		}
		finally
		{
			log.info("In Finally");
			Manager.endSession(session);
		}

		return response;
	}

	@PostMapping()
	private ResponseEntity<String> createLogin(@Valid @RequestBody Login login) throws IOException
	{

		log.info("---> Request: Going to Insert Login Data: " + login.toString());
		try
		{
			session = Manager.getSessionFactory().openSession();
			tx = session.beginTransaction();

			login.setCreatedTimestamp(new Date());
			session.save(login);

			tx.commit();

			LoginBean loginBean = service.serializeLoginData(login);

			DataBean dataBean = new DataBean();
			dataBean.setLoginBean(loginBean);

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

	@DeleteMapping(value = "/{loginId}")
	private String deleteLogin(@PathVariable(required = true) int loginId)
	{
		String message = "Delete Single Entry of Logins";
		System.out.println(message);
		return message;
	}
}