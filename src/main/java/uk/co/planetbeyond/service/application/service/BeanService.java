package uk.co.planetbeyond.service.application.service;

import java.util.Base64;

import org.springframework.stereotype.Service;

import uk.co.planetbeyond.service.application.generated.bean.Department;
import uk.co.planetbeyond.service.application.generated.bean.Employee;
import uk.co.planetbeyond.service.application.generated.bean.EmployeeEvaluation;
import uk.co.planetbeyond.service.application.generated.bean.EmployeePersonalDetails;
import uk.co.planetbeyond.service.application.generated.bean.EvaluationCriteria;
import uk.co.planetbeyond.service.application.generated.bean.EvaluationParameter;
import uk.co.planetbeyond.service.application.generated.bean.Login;
import uk.co.planetbeyond.service.application.response.bean.DepartmentBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeeBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeeEvaluationBean;
import uk.co.planetbeyond.service.application.response.bean.EmployeePersonalDetailsBean;
import uk.co.planetbeyond.service.application.response.bean.EvaluationCriteriaBean;
import uk.co.planetbeyond.service.application.response.bean.EvaluationParameterBean;
import uk.co.planetbeyond.service.application.response.bean.LoginBean;

@Service
public class BeanService
{

	public LoginBean serializeLoginData(Login login)
	{
		LoginBean loginBean = new LoginBean();

		loginBean.setLoginId(login.getLoginId());
		loginBean.setEmployee(serializeEmployeeData(login.getEmployee()));
		loginBean.setUserName(login.getUserName());
		loginBean.setPassword(login.getPassword());
		loginBean.setCreatedTimestamp(login.getCreatedTimestamp());

		return loginBean;
	}

	public EmployeeBean serializeEmployeeData(Employee employee)
	{
		EmployeeBean employeeBean = new EmployeeBean();

		employeeBean.setEmployeeId(employee.getEmployeeId());
		employeeBean.setDesignation(employee.getDesignation());
		employeeBean.setLevel(employee.getLevel());
		employeeBean.setOfficeEmail(employee.getOfficeEmail());
		employeeBean.setOfficeContact(employee.getOfficeContact());
		employeeBean.setEmployeePersonalDetails(serializeEmployeePersonalDetailsData(employee.getEmployeePersonalDetails()));
		employeeBean.setDepartment(serializeDepartmentData(employee.getDepartment()));
		employeeBean.setExEmployee(employee.isExEmployee());
		employeeBean.setCreatedTimestamp(employee.getCreatedTimestamp());
		employeeBean.setEvaluationStatus(employee.getEvaluationStatus());

		return employeeBean;
	}

	public EmployeePersonalDetailsBean serializeEmployeePersonalDetailsData(EmployeePersonalDetails employeePersonalDetails)
	{
		EmployeePersonalDetailsBean employeePersonalDetailsBean = new EmployeePersonalDetailsBean();

		employeePersonalDetailsBean.setEmployeePersonalDetailsId(employeePersonalDetails.getEmployeePersonalDetailsId());
		employeePersonalDetailsBean.setFirstName(employeePersonalDetails.getFirstName());
		employeePersonalDetailsBean.setLastName(employeePersonalDetails.getLastName());
		employeePersonalDetailsBean.setFatherName(employeePersonalDetails.getFatherName());
		employeePersonalDetailsBean.setCnicNo(employeePersonalDetails.getCnicNo());
		employeePersonalDetailsBean.setGender(employeePersonalDetails.getGender());
		employeePersonalDetailsBean.setAge(employeePersonalDetails.getAge());
		employeePersonalDetailsBean.setPersonalContactNo(employeePersonalDetails.getPersonalContactNo());
		employeePersonalDetailsBean.setEducation(employeePersonalDetails.getEducation());
		employeePersonalDetailsBean.setCurrentAddress(employeePersonalDetails.getCurrentAddress());
		employeePersonalDetailsBean.setPermanentAddress(employeePersonalDetails.getPermanentAddress());
		employeePersonalDetailsBean.setPicture(byteArrayToBase64(employeePersonalDetails.getPicture()));
		employeePersonalDetailsBean.setCreatedTimestamp(employeePersonalDetails.getCreatedTimestamp());

		return employeePersonalDetailsBean;
	}

	private String byteArrayToBase64(byte[] bytesArray)
	{
		if(bytesArray!=null)
		{
			byte[] bytes = bytesArray;
			String base64File = "";
			return base64File = Base64.getEncoder().encodeToString(bytes);
		}
		else 
		{
			return "";
		}
	}
	
	public DepartmentBean serializeDepartmentData(Department department)
	{
		DepartmentBean departmentBean = new DepartmentBean();

		departmentBean.setDepartmentId(department.getDepartmentId());
		departmentBean.setName(department.getName());
		departmentBean.setEvaluationStatus(department.isEvaluationStatus());
		departmentBean.setEvaluationStartTimestamp(department.getEvaluationStartTimestamp());
		departmentBean.setEvaluationEndTimestamp(department.getEvaluationEndTimestamp());
		departmentBean.setCreatedTimestamp(department.getCreatedTimestamp());

		return departmentBean;
	}

	public EmployeeEvaluationBean serializeEmployeeEvaluationData(EmployeeEvaluation employeeEvaluation)
	{
		EmployeeEvaluationBean employeeEvaluationBean = new EmployeeEvaluationBean();

		employeeEvaluationBean.setEmployeeEvaluationId(employeeEvaluation.getEmployeeEvaluationId());
		employeeEvaluationBean.setEmployee(serializeEmployeeData(employeeEvaluation.getEmployee()));
		employeeEvaluationBean.setEvaluationParameterName(employeeEvaluation.getEvaluationParameterName());
		employeeEvaluationBean.setSelfRatedValue(employeeEvaluation.getSelfRatedValue());
		employeeEvaluationBean.setManagerRatedValue(employeeEvaluation.getManagerRatedValue());
		employeeEvaluationBean.setSelfProvidedComments(employeeEvaluation.getSelfProvidedComments());
		employeeEvaluationBean.setManagerProvidedComments(employeeEvaluation.getManagerProvidedComments());
		employeeEvaluationBean.setEvaluatedBy(employeeEvaluation.getEvaluatedBy());
		employeeEvaluationBean.setEvaluationParameterCategory(employeeEvaluation.getEvaluationParameterCategory());
		employeeEvaluationBean.setCreatedTimestamp(employeeEvaluation.getCreatedTimestamp());

		return employeeEvaluationBean;
	}

	public EvaluationCriteriaBean serializeEvaluationCriteriaData(EvaluationCriteria evaluationCriteria)
	{
		EvaluationCriteriaBean evaluationCriteriaBean = new EvaluationCriteriaBean();

		evaluationCriteriaBean.setEvaluationCriteriaId(evaluationCriteria.getEvaluationCriteriaId());
		evaluationCriteriaBean.setEvaluationCategory(evaluationCriteria.getEvaluationCategory());
		evaluationCriteriaBean.setEvaluationParameter(serializeevaluationParameterData(evaluationCriteria.getEvaluationParameter()));
		evaluationCriteriaBean.setDepartment(serializeDepartmentData(evaluationCriteria.getDepartment()));
		evaluationCriteriaBean.setCreatedTimestamp(evaluationCriteria.getCreatedTimestamp());

		return evaluationCriteriaBean;
	}

	public EvaluationParameterBean serializeevaluationParameterData(EvaluationParameter evaluationParameter)
	{
		EvaluationParameterBean evaluationParameterBean = new EvaluationParameterBean();

		evaluationParameterBean.setEvaluationParameterId(evaluationParameter.getEvaluationParameterId());
		evaluationParameterBean.setName(evaluationParameter.getName());
		evaluationParameterBean.setDescription(evaluationParameter.getDescription());
		evaluationParameterBean.setCreatedTimestamp(evaluationParameter.getCreatedTimestamp());
		

		return evaluationParameterBean;
	}
}
