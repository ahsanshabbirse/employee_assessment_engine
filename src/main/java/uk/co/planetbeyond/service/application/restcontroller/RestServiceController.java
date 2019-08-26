package uk.co.planetbeyond.service.application.restcontroller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import uk.co.planetbeyond.service.application.constants.Constants;
import uk.co.planetbeyond.service.application.service.BeanService;
import uk.co.planetbeyond.service.application.util.Utils;

@CrossOrigin(value = Constants.CROSS_ORIGIN)
public abstract class RestServiceController
{
	protected Logger log = LoggerFactory.getLogger(getClass());

	protected static Session session;
	protected static Transaction tx;
	protected ResponseEntity<String> response;

	@Autowired
	protected BeanService service;
	@Autowired
	protected Utils utils;
}
