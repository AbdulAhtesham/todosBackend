package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.Date;

public class TodoUpdateBean {
	private String description;
	private Date completionDate;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	@Override
	public String toString() {
		return "TodoUpdateBean [description=" + description + ", completionDate=" + completionDate + "]";
	}
	
	

}
