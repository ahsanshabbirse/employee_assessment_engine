package uk.co.planetbeyond.service.application.response.bean;

import org.springframework.stereotype.Component;

@Component
public class PageInfoBean
{
	private int pageNumber;
	private int displayedRecords;
	private int remainingRecords;
	private int totalPages;

	public int getPageNumber()
	{
		return pageNumber;
	}

	public void setPageNumber(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	public int getDisplayedRecords()
	{
		return displayedRecords;
	}

	public void setDisplayedRecords(int displayedRecords)
	{
		this.displayedRecords = displayedRecords;
	}

	public int getRemainingRecords()
	{
		return remainingRecords;
	}

	public void setRemainingRecords(int remainingRecords)
	{
		this.remainingRecords = remainingRecords;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

}
