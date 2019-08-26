package uk.co.planetbeyond.service.application.response.bean;

import org.springframework.stereotype.Component;

@Component
public class ResponseBean
{
	private String responseMessage;
	private DataBean data;
	private PageInfoBean pageInfo;

	public String getResponseMessage()
	{
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage)
	{
		this.responseMessage = responseMessage;
	}

	public DataBean getDataBean()
	{
		return data;
	}

	public void setDataBean(DataBean dataBean)
	{
		this.data = dataBean;
	}

	public PageInfoBean getPageInfo()
	{
		return pageInfo;
	}

	public void setPageInfo(PageInfoBean pageInfo)
	{
		this.pageInfo = pageInfo;
	}

}
