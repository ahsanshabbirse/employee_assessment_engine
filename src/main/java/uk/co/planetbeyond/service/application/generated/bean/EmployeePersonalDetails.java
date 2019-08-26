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
import javax.persistence.UniqueConstraint;

/**
 * EmployeePersonalDetails generated by hbm2java
 */
@Entity
@Table(name = "employee_personal_details", catalog = "employee_assessment", uniqueConstraints = { @UniqueConstraint(columnNames = "cnic_no"), @UniqueConstraint(columnNames = "personal_contact_no") })
public class EmployeePersonalDetails implements java.io.Serializable
{

	private Integer employeePersonalDetailsId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String cnicNo;
	private Boolean gender;
	private Integer age;
	private String personalContactNo;
	private String education;
	private String currentAddress;
	private String permanentAddress;
	private byte[] picture;
	private Date createdTimestamp;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public EmployeePersonalDetails()
	{
	}

	public EmployeePersonalDetails(String firstName, String lastName, String fatherName, String cnicNo, String personalContactNo, String currentAddress, Date createdTimestamp)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.cnicNo = cnicNo;
		this.personalContactNo = personalContactNo;
		this.currentAddress = currentAddress;
		this.createdTimestamp = createdTimestamp;
	}

	public EmployeePersonalDetails(String firstName, String lastName, String fatherName, String cnicNo, Boolean gender, Integer age, String personalContactNo, String education, String currentAddress, String permanentAddress, byte[] picture, Date createdTimestamp, Set<Employee> employees)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.cnicNo = cnicNo;
		this.gender = gender;
		this.age = age;
		this.personalContactNo = personalContactNo;
		this.education = education;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.picture = picture;
		this.createdTimestamp = createdTimestamp;
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "employee_personal_details_id", unique = true, nullable = false)
	public Integer getEmployeePersonalDetailsId()
	{
		return this.employeePersonalDetailsId;
	}

	public void setEmployeePersonalDetailsId(Integer employeePersonalDetailsId)
	{
		this.employeePersonalDetailsId = employeePersonalDetailsId;
	}

	@Column(name = "first_name", nullable = false, length = 15)
	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 15)
	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Column(name = "father_name", nullable = false, length = 30)
	public String getFatherName()
	{
		return this.fatherName;
	}

	public void setFatherName(String fatherName)
	{
		this.fatherName = fatherName;
	}

	@Column(name = "cnic_no", unique = true, nullable = false, length = 15)
	public String getCnicNo()
	{
		return this.cnicNo;
	}

	public void setCnicNo(String cnicNo)
	{
		this.cnicNo = cnicNo;
	}

	@Column(name = "gender")
	public Boolean getGender()
	{
		return this.gender;
	}

	public void setGender(Boolean gender)
	{
		this.gender = gender;
	}

	@Column(name = "age")
	public Integer getAge()
	{
		return this.age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	@Column(name = "personal_contact_no", unique = true, nullable = false, length = 15)
	public String getPersonalContactNo()
	{
		return this.personalContactNo;
	}

	public void setPersonalContactNo(String personalContactNo)
	{
		this.personalContactNo = personalContactNo;
	}

	@Column(name = "education", length = 45)
	public String getEducation()
	{
		return this.education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	@Column(name = "current_address", nullable = false, length = 50)
	public String getCurrentAddress()
	{
		return this.currentAddress;
	}

	public void setCurrentAddress(String currentAddress)
	{
		this.currentAddress = currentAddress;
	}

	@Column(name = "permanent_address", length = 50)
	public String getPermanentAddress()
	{
		return this.permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress)
	{
		this.permanentAddress = permanentAddress;
	}

	@Column(name = "picture")
	public byte[] getPicture()
	{
		return this.picture;
	}

	public void setPicture(byte[] picture)
	{
		this.picture = picture;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employeePersonalDetails")
	public Set<Employee> getEmployees()
	{
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}

}
