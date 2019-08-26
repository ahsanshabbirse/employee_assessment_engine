package uk.co.planetbeyond.service.application.response.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DepartmentBean
{
	private Integer departmentId;
	private String name;
	private boolean evaluationStatus;
	private Date evaluationStartTimestamp;
	private Date evaluationEndTimestamp;
	
	public boolean isEvaluationStatus()
	{
		return evaluationStatus;
	}

	public void setEvaluationStatus(boolean evaluationStatus)
	{
		this.evaluationStatus = evaluationStatus;
	}

	private Date createdTimestamp;

	public Integer getDepartmentId()
	{
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId)
	{
		this.departmentId = departmentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	

	public Date getCreatedTimestamp()
	{
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp)
	{
		this.createdTimestamp = createdTimestamp;
	}

	public Date getEvaluationStartTimestamp()
	{
		return evaluationStartTimestamp;
	}

	public void setEvaluationStartTimestamp(Date evaluationStartTimestamp)
	{
		this.evaluationStartTimestamp = evaluationStartTimestamp;
	}

	public Date getEvaluationEndTimestamp()
	{
		return evaluationEndTimestamp;
	}

	public void setEvaluationEndTimestamp(Date evaluationEndTimestamp)
	{
		this.evaluationEndTimestamp = evaluationEndTimestamp;
	}

}
