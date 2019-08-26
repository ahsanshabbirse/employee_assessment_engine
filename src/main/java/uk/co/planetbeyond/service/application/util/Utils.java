package uk.co.planetbeyond.service.application.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import freemarker.core.ParseException;
import uk.co.planetbeyond.service.application.response.bean.DataBean;
import uk.co.planetbeyond.service.application.response.bean.PageInfoBean;
import uk.co.planetbeyond.service.application.response.bean.ResponseBean;

@Service
public class Utils
{
	private static Logger log = LoggerFactory.getLogger(Utils.class);

	private ResponseBean responseBean = new ResponseBean();

	private HttpHeaders getHeader()
	{
		HttpHeaders header = new HttpHeaders();
		// header.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, Constants.get().ACCESS_CONTROL_ALLOW_ORIGIN);
		// header.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, Constants.get().ACCESS_CONTROL_ALLOW_CREDENTIALS);
		// header.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, OPTIONS, DELETE, PUT");
		// header.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type");
		// header.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return header;
	}

	public ResponseEntity<String> createResponse(String message)
	{
		responseBean.setResponseMessage(message);
		responseBean.setDataBean(null);
		responseBean.setPageInfo(null);

		return response();
	}

	public ResponseEntity<String> createResponse(DataBean dataBean, String message)
	{
		responseBean.setDataBean(dataBean);
		responseBean.setResponseMessage(message);
		responseBean.setPageInfo(null);
		

		return response();
	}

	public ResponseEntity<String> createResponse(DataBean dataBean, PageInfoBean pageInfoBean, String message)
	{
		responseBean.setDataBean(dataBean);
		responseBean.setPageInfo(pageInfoBean);
		responseBean.setResponseMessage(message);

		return response();
	}

	private ResponseEntity<String> response()
	{
		try {
		Gson gson = new Gson().newBuilder().setDateFormat("yyyy-MM-dd").create();
		String responseData = gson.toJson(responseBean);

		ResponseEntity<String> response = ResponseEntity.ok().body(responseData);
		log.info("<--- Response: " + response.getStatusCodeValue() + " Provided Data: " + response.getBody());

		return response;
		}
		catch (Exception e) {
			log.error(e.toString(),e);
			return null;
		}
	}

	public void handleException(Throwable ex, Transaction tx, Logger log)
	{
		if (tx != null)
			tx.rollback();

		log.error(ex.toString(), ex);
	}

	public ResponseEntity<String> handleException(Throwable ex, Transaction tx, Logger log, String message)
	{
		if (tx != null)
			tx.rollback();

		log.error(ex.toString(), ex);

		return createResponse(message);
	}
	
	/**
	 * encrypts plain text into md5 encoded string.
	 * @param password
	 * @return
	 */
	public static String md5Encode(String password)
	{
		MessageDigest md;
		try
		{
			md = MessageDigest.getInstance("MD5");

			byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes)
			{
				sb.append(String.format("%02x", b));
			}
			System.out.println(sb.toString());

			return sb.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			log.error(e.toString(),e);
		}
		return null;
	}
	
	public static Date parseDate(String date)
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    try
		{
			return formatter.parse(date);
		}
		catch (java.text.ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}
