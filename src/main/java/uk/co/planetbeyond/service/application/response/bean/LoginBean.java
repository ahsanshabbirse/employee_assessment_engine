package uk.co.planetbeyond.service.application.response.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class LoginBean
{
	private Integer loginId;
	private EmployeeBean employee;
	private String userName;
	private String password;
	private Date createdTimestamp;

	public Integer getLoginId()
	{
		return loginId;
	}

	public void setLoginId(Integer loginId)
	{
		this.loginId = loginId;
	}

	public EmployeeBean getEmployee()
	{
		return employee;
	}

	public void setEmployee(EmployeeBean employee)
	{
		this.employee = employee;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
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
