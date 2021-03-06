package uk.co.planetbeyond.service.application.generated.bean;
// Generated Aug 21, 2019 12:26:52 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EvaluationParameter generated by hbm2java
 */
@Entity
@Table(name = "evaluation_parameter", catalog = "employee_assessment")
public class EvaluationParameter implements java.io.Serializable
{

	private Integer evaluationParameterId;
	private String name;
	private String description;
	private Date createdTimestamp;
	private Set<EvaluationCriteria> evaluationCriterias = new HashSet<EvaluationCriteria>(0);

	public EvaluationParameter()
	{
	}

	public EvaluationParameter(String name, String description, Date createdTimestamp)
	{
		this.name = name;
		this.description = description;
		this.createdTimestamp = createdTimestamp;
	}

	public EvaluationParameter(String name, String description, Date createdTimestamp, Set<EvaluationCriteria> evaluationCriterias)
	{
		this.name = name;
		this.description = description;
		this.createdTimestamp = createdTimestamp;
		this.evaluationCriterias = evaluationCriterias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "evaluation_parameter_id", unique = true, nullable = false)
	public Integer getEvaluationParameterId()
	{
		return this.evaluationParameterId;
	}

	public void setEvaluationParameterId(Integer evaluationParameterId)
	{
		this.evaluationParameterId = evaluationParameterId;
	}

	@Column(name = "name", nullable = false, length = 25)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 200)
	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_timestamp", nullable = false, length = 19)
	public Date getCreatedTimestamp()
	{
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp)
	{
		this.createdTimestamp = createdTimestamp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "evaluationParameter")
	public Set<EvaluationCriteria> getEvaluationCriterias()
	{
		return this.evaluationCriterias;
	}

	public void setEvaluationCriterias(Set<EvaluationCriteria> evaluationCriterias)
	{
		this.evaluationCriterias = evaluationCriterias;
	}

}
