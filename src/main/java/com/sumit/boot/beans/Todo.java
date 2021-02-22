package com.sumit.boot.beans;

import java.time.LocalDate;

public class Todo {

	private long id;
	private String userName;
	private String description;
	private boolean istoDoCompleted;
	private LocalDate targetDate;
	
	public Todo(long id, String userName, String description, LocalDate date, boolean istoDoCompleted) {
		super();
		this.id = id;
		this.userName = userName;
		this.description = description;
		this.targetDate = date;
		this.istoDoCompleted = istoDoCompleted;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		if(userName==null) {
			return "sumit";
		}
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIstoDoCompleted() {
		return istoDoCompleted;
	}

	public void setIstoDoCompleted(boolean istoDoCompleted) {
		this.istoDoCompleted = istoDoCompleted;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", userName=" + userName + ", description=" + description + ", istoDoCompleted="
				+ istoDoCompleted + ", targetDate=" + targetDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
