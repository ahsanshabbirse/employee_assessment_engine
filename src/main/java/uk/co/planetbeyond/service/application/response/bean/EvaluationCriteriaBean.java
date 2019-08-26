package uk.co.planetbeyond.service.application.response.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import uk.co.planetbeyond.service.application.generated.bean.Department;
import uk.co.planetbeyond.service.application.generated.bean.EmployeeEvaluation;
import uk.co.planetbeyond.service.application.generated.bean.EvaluationParameter;
import uk.co.planetbeyond.service.application.restcontroller.EmployeeEvaluationController;

@Component
public class EvaluationCriteriaBean
{
	private Integer evaluationCriteriaId;
	private DepartmentBean department;
	private EvaluationParameterBean evaluationParameter;
	private byte evaluationCategory;
	private Date createdTimestamp;
	
	public Integer getEvaluationCriteriaId()
	{
		return evaluationCriteriaId;
	}
	public void setEvaluationCriteriaId(Integer evaluationCriteriaId)
	{
		this.evaluationCriteriaId = evaluationCriteriaId;
	}
	public DepartmentBean getDepartment()
	{
		return department;
	}
	public void setDepartment(DepartmentBean department)
	{
		this.department = department;
	}
	public EvaluationParameterBean getEvaluationParameter()
	{
		return evaluationParameter;
	}
	public void setEvaluationParameter(EvaluationParameterBean evaluationParameter)
	{
		this.evaluationParameter = evaluationParameter;
	}
	public byte getEvaluationCategory()
	{
		return evaluationCategory;
	}
	public void setEvaluationCategory(byte evaluationCategory)
	{
		this.evaluationCategory = evaluationCategory;
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
