package uk.co.planetbeyond.service.application.generated.bean;
// Generated Aug 21, 2019 12:26:52 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EvaluationCriteria generated by hbm2java
 */
@Entity
@Table(name = "evaluation_criteria", catalog = "employee_assessment")
public class EvaluationCriteria implements java.io.Serializable
{

	private Integer evaluationCriteriaId;
	private Department department;
	private EvaluationParameter evaluationParameter;
	private byte evaluationCategory;
	private Date createdTimestamp;

	public EvaluationCriteria()
	{
	}

	public EvaluationCriteria(Department department, EvaluationParameter evaluationParameter, byte evaluationCategory, Date createdTimestamp)
	{
		this.department = department;
		this.evaluationParameter = evaluationParameter;
		this.evaluationCategory = evaluationCategory;
		this.createdTimestamp = createdTimestamp;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "evaluation_criteria_id", unique = true, nullable = false)
	public Integer getEvaluationCriteriaId()
	{
		return this.evaluationCriteriaId;
	}

	public void setEvaluationCriteriaId(Integer evaluationCriteriaId)
	{
		this.evaluationCriteriaId = evaluationCriteriaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	public Department getDepartment()
	{
		return this.department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evaluation_parameter_id", nullable = false)
	public EvaluationParameter getEvaluationParameter()
	{
		return this.evaluationParameter;
	}

	public void setEvaluationParameter(EvaluationParameter evaluationParameter)
	{
		this.evaluationParameter = evaluationParameter;
	}

	@Column(name = "evaluation_category", nullable = false)
	public byte getEvaluationCategory()
	{
		return this.evaluationCategory;
	}

	public void setEvaluationCategory(byte evaluationCategory)
	{
		this.evaluationCategory = evaluationCategory;
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

}
