package org.william.model;

import java.io.Serializable;
import java.util.Date;

public class Student  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String sex;
	
	private Date createdAt;
	
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
