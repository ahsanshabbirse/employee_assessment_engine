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
 * EmployeeEvaluation generated by hbm2java
 */
@Entity
@Table(name = "employee_evaluation", catalog = "employee_assessment")
public class EmployeeEvaluation implements java.io.Serializable
{

	private Integer employeeEvaluationId;
	private Employee employee;
	private String evaluationParameterName;
	private Short selfRatedValue;
	private Short managerRatedValue;
	private String selfProvidedComments;
	private String managerProvidedComments;
	private Integer evaluatedBy;
	private byte evaluationParameterCategory;
	private Date createdTimestamp;

	public EmployeeEvaluation()
	{
	}

	public EmployeeEvaluation(Employee employee, String evaluationParameterName, byte evaluationParameterCategory, Date createdTimestamp)
	{
		this.employee = employee;
		this.evaluationParameterName = evaluationParameterName;
		this.evaluationParameterCategory = evaluationParameterCategory;
		this.createdTimestamp = createdTimestamp;
	}

	public EmployeeEvaluation(Employee employee, String evaluationParameterName, Short selfRatedValue, Short managerRatedValue, String selfProvidedComments, String managerProvidedComments, Integer evaluatedBy, byte evaluationParameterCategory, Date createdTimestamp)
	{
		this.employee = employee;
		this.evaluationParameterName = evaluationParameterName;
		this.selfRatedValue = selfRatedValue;
		this.managerRatedValue = managerRatedValue;
		this.selfProvidedComments = selfProvidedComments;
		this.managerProvidedComments = managerProvidedComments;
		this.evaluatedBy = evaluatedBy;
		this.evaluationParameterCategory = evaluationParameterCategory;
		this.createdTimestamp = createdTimestamp;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "employee_evaluation_id", unique = true, nullable = false)
	public Integer getEmployeeEvaluationId()
	{
		return this.employeeEvaluationId;
	}

	public void setEmployeeEvaluationId(Integer employeeEvaluationId)
	{
		this.employeeEvaluationId = employeeEvaluationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	public Employee getEmployee()
	{
		return this.employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	@Column(name = "evaluation_parameter_name", nullable = false, length = 200)
	public String getEvaluationParameterName()
	{
		return this.evaluationParameterName;
	}

	public void setEvaluationParameterName(String evaluationParameterName)
	{
		this.evaluationParameterName = evaluationParameterName;
	}

	@Column(name = "self_rated_value")
	public Short getSelfRatedValue()
	{
		return this.selfRatedValue;
	}

	public void setSelfRatedValue(Short selfRatedValue)
	{
		this.selfRatedValue = selfRatedValue;
	}

	@Column(name = "manager_rated_value")
	public Short getManagerRatedValue()
	{
		return this.managerRatedValue;
	}

	public void setManagerRatedValue(Short managerRatedValue)
	{
		this.managerRatedValue = managerRatedValue;
	}

	@Column(name = "self_provided_comments", length = 1000)
	public String getSelfProvidedComments()
	{
		return this.selfProvidedComments;
	}

	public void setSelfProvidedComments(String selfProvidedComments)
	{
		this.selfProvidedComments = selfProvidedComments;
	}

	@Column(name = "manager_provided_comments", length = 1000)
	public String getManagerProvidedComments()
	{
		return this.managerProvidedComments;
	}

	public void setManagerProvidedComments(String managerProvidedComments)
	{
		this.managerProvidedComments = managerProvidedComments;
	}

	@Column(name = "evaluated_by")
	public Integer getEvaluatedBy()
	{
		return this.evaluatedBy;
	}

	public void setEvaluatedBy(Integer evaluatedBy)
	{
		this.evaluatedBy = evaluatedBy;
	}

	@Column(name = "evaluation_parameter_category", nullable = false)
	public byte getEvaluationParameterCategory()
	{
		return this.evaluationParameterCategory;
	}

	public void setEvaluationParameterCategory(byte evaluationParameterCategory)
	{
		this.evaluationParameterCategory = evaluationParameterCategory;
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
