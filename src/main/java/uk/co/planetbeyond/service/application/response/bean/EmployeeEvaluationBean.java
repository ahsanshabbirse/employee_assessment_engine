package uk.co.planetbeyond.service.application.response.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeEvaluationBean
{
	private Integer employeeEvaluationId;
	private EmployeeBean employee;
	private String evaluationParameterName;
	private short selfRatedValue;
	private Short managerRatedValue;
	private String selfProvidedComments;
	private String managerProvidedComments;
	private Integer evaluatedBy;
	private byte evaluationParameterCategory;
	private Date createdTimestamp;
	public Integer getEmployeeEvaluationId()
	{
		return employeeEvaluationId;
	}
	public void setEmployeeEvaluationId(Integer employeeEvaluationId)
	{
		this.employeeEvaluationId = employeeEvaluationId;
	}
	public EmployeeBean getEmployee()
	{
		return employee;
	}
	public void setEmployee(EmployeeBean employee)
	{
		this.employee = employee;
	}
	public String getEvaluationParameterName()
	{
		return evaluationParameterName;
	}
	public void setEvaluationParameterName(String evaluationParameterName)
	{
		this.evaluationParameterName = evaluationParameterName;
	}
	public short getSelfRatedValue()
	{
		return selfRatedValue;
	}
	public void setSelfRatedValue(short selfRatedValue)
	{
		this.selfRatedValue = selfRatedValue;
	}
	public Short getManagerRatedValue()
	{
		return managerRatedValue;
	}
	public void setManagerRatedValue(Short managerRatedValue)
	{
		this.managerRatedValue = managerRatedValue;
	}
	public String getSelfProvidedComments()
	{
		return selfProvidedComments;
	}
	public void setSelfProvidedComments(String selfProvidedComments)
	{
		this.selfProvidedComments = selfProvidedComments;
	}
	public String getManagerProvidedComments()
	{
		return managerProvidedComments;
	}
	public void setManagerProvidedComments(String managerProvidedComments)
	{
		this.managerProvidedComments = managerProvidedComments;
	}
	public Integer getEvaluatedBy()
	{
		return evaluatedBy;
	}
	public void setEvaluatedBy(Integer evaluatedBy)
	{
		this.evaluatedBy = evaluatedBy;
	}
	public byte getEvaluationParameterCategory()
	{
		return evaluationParameterCategory;
	}
	public void setEvaluationParameterCategory(byte evaluationParameterCategory)
	{
		this.evaluationParameterCategory = evaluationParameterCategory;
	}
	public Date getCreatedTimestamp()
	{
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp)
	{
		this.createdTimestamp = createdTimestamp;
	}


}
