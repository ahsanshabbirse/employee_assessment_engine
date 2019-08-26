package uk.co.planetbeyond.service.application.response.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import uk.co.planetbeyond.service.application.generated.bean.EvaluationCriteria;

@Component
public class EvaluationParameterBean
{
	private Integer evaluationParameterId;
	private String name;
	private String description;
	private Date createdTimestamp;

	public Integer getEvaluationParameterId()
	{
		return evaluationParameterId;
	}

	public void setEvaluationParameterId(Integer evaluationParameterId)
	{
		this.evaluationParameterId = evaluationParameterId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
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
