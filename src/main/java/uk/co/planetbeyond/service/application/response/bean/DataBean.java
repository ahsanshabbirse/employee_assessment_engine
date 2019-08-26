package uk.co.planetbeyond.service.application.response.bean;

import java.util.List;

public class DataBean
{

	private LoginBean login;
	private List<LoginBean> loginList;
	private EmployeeBean employee;
	private List<EmployeeBean> employeeList;
	private EmployeePersonalDetailsBean employeePersonalDetails;
	private DepartmentBean department;
	private List<DepartmentBean> departmentList;
	private EvaluationCriteriaBean evaluationCriteria;
	private List<EvaluationCriteriaBean> evaluationCriteriaList;
	private EvaluationParameterBean evaluationParameter;
	private List<EvaluationParameterBean> evaluationParameterList;
	private EmployeeEvaluationBean employeeEvaluation;
	private List<EmployeeEvaluationBean> employeeEvaluationList;

	public LoginBean getLoginBean()
	{
		return login;
	}

	public void setLoginBean(LoginBean loginBean)
	{
		this.login = loginBean;
	}

	public List<LoginBean> getLoginBeanList()
	{
		return loginList;
	}

	public void setLoginBeanList(List<LoginBean> loginBeanList)
	{
		this.loginList = loginBeanList;
	}

	public EmployeeBean getEmployeeBean()
	{
		return employee;
	}

	public void setEmployeeBean(EmployeeBean employeeBean)
	{
		this.employee = employeeBean;
	}

	public List<EmployeeBean> getEmployeeBeanList()
	{
		return employeeList;
	}

	public void setEmployeeBeanList(List<EmployeeBean> employeeBeanList)
	{
		this.employeeList = employeeBeanList;
	}

	public EmployeePersonalDetailsBean getEmployeePersonalDetailsBean()
	{
		return employeePersonalDetails;
	}

	public void setEmployeePersonalDetailsBean(EmployeePersonalDetailsBean employeePersonalDetailsBean)
	{
		this.employeePersonalDetails = employeePersonalDetailsBean;
	}

	public DepartmentBean getDepartmentBean()
	{
		return department;
	}

	public void setDepartmentBean(DepartmentBean departmentBean)
	{
		this.department = departmentBean;
	}

	public List<DepartmentBean> getDepartmentBeanList()
	{
		return departmentList;
	}

	public void setDepartmentBeanList(List<DepartmentBean> departmentBeanList)
	{
		this.departmentList = departmentBeanList;
	}

	public EvaluationCriteriaBean getEvaluationCriteriaBean()
	{
		return evaluationCriteria;
	}

	public void setEvaluationCriteriaBean(EvaluationCriteriaBean evaluationCriteriaBean)
	{
		this.evaluationCriteria = evaluationCriteriaBean;
	}

	public List<EvaluationCriteriaBean> getEvaluationCriteriaList()
	{
		return evaluationCriteriaList;
	}

	public void setEvaluationCriteriaList(List<EvaluationCriteriaBean> evaluationCriteriaList)
	{
		this.evaluationCriteriaList = evaluationCriteriaList;
	}

	public EvaluationParameterBean getEvaluationParameterBean()
	{
		return evaluationParameter;
	}

	public void setEvaluationParameterBean(EvaluationParameterBean evaluationParameterBean)
	{
		this.evaluationParameter = evaluationParameterBean;
	}

	public List<EvaluationParameterBean> getEvaluationParameterBeanList()
	{
		return evaluationParameterList;
	}

	public void setEvaluationParameterBeanList(List<EvaluationParameterBean> evaluationParameterBeanList)
	{
		this.evaluationParameterList = evaluationParameterBeanList;
	}

	public EmployeeEvaluationBean getEmployeeEvaluationBean()
	{
		return employeeEvaluation;
	}

	public void setEmployeeEvaluationBean(EmployeeEvaluationBean employeeEvaluationBean)
	{
		this.employeeEvaluation = employeeEvaluationBean;
	}

	public List<EmployeeEvaluationBean> getEmployeeEvaluationBeanList()
	{
		return employeeEvaluationList;
	}

	public void setEmployeeEvaluationBeanList(List<EmployeeEvaluationBean> employeeEvaluationBeanList)
	{
		this.employeeEvaluationList = employeeEvaluationBeanList;
	}

}
