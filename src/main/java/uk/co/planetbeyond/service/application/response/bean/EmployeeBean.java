package uk.co.planetbeyond.service.application.response.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeBean
{
	private Integer employeeId;
	private EmployeePersonalDetailsBean employeePersonalDetails;
	private byte designation;
	private byte level;
	private String officeEmail;
	private String officeContact;
	private DepartmentBean department;
	private boolean exEmployee;
	private Date createdTimestamp;
	private int evaluationStatus;
	public Integer getEmployeeId()
	{
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId)
	{
		this.employeeId = employeeId;
	}
	public EmployeePersonalDetailsBean getEmployeePersonalDetails()
	{
		return employeePersonalDetails;
	}
	public void setEmployeePersonalDetails(EmployeePersonalDetailsBean employeePersonalDetails)
	{
		this.employeePersonalDetails = employeePersonalDetails;
	}
	public byte getDesignation()
	{
		return designation;
	}
	public void setDesignation(byte designation)
	{
		this.designation = designation;
	}
	public byte getLevel()
	{
		return level;
	}
	public void setLevel(byte level)
	{
		this.level = level;
	}
	public String getOfficeEmail()
	{
		return officeEmail;
	}
	public void setOfficeEmail(String officeEmail)
	{
		this.officeEmail = officeEmail;
	}
	public String getOfficeContact()
	{
		return officeContact;
	}
	public void setOfficeContact(String officeContact)
	{
		this.officeContact = officeContact;
	}
	public DepartmentBean getDepartment()
	{
		return department;
	}
	public void setDepartment(DepartmentBean department)
	{
		this.department = department;
	}
	public boolean isExEmployee()
	{
		return exEmployee;
	}
	public void setExEmployee(boolean exEmployee)
	{
		this.exEmployee = exEmployee;
	}
	public Date getCreatedTimestamp()
	{
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp)
	{
		this.createdTimestamp = createdTimestamp;
	}
	public int getEvaluationStatus()
	{
		return evaluationStatus;
	}
	public void setEvaluationStatus(int evaluationStatus)
	{
		this.evaluationStatus = evaluationStatus;
	}

	

}
