package uk.co.planetbeyond.service.application.response.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeePersonalDetailsBean
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
	private String picture;
	private Date createdTimestamp;

	public Integer getEmployeePersonalDetailsId()
	{
		return employeePersonalDetailsId;
	}

	public void setEmployeePersonalDetailsId(Integer employeePersonalDetailsId)
	{
		this.employeePersonalDetailsId = employeePersonalDetailsId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFatherName()
	{
		return fatherName;
	}

	public void setFatherName(String fatherName)
	{
		this.fatherName = fatherName;
	}

	public String getCnicNo()
	{
		return cnicNo;
	}

	public void setCnicNo(String cnicNo)
	{
		this.cnicNo = cnicNo;
	}

	public Boolean getGender()
	{
		return gender;
	}

	public void setGender(Boolean gender)
	{
		this.gender = gender;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getPersonalContactNo()
	{
		return personalContactNo;
	}

	public void setPersonalContactNo(String personalContactNo)
	{
		this.personalContactNo = personalContactNo;
	}

	public String getEducation()
	{
		return education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	public String getCurrentAddress()
	{
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress)
	{
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress()
	{
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress)
	{
		this.permanentAddress = permanentAddress;
	}

	public String getPicture()
	{
		return picture;
	}

	public void setPicture(String picture)
	{
		this.picture = picture;
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
