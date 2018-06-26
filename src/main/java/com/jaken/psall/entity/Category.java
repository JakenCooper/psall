package com.jaken.psall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="t_category")
public class Category {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="user_id")
	private String userId;
	@Column(name="p_category_id")
	private String pCategoryId;
	
	@Transient
	private User user;
	
	public Category(String id, String name, String userId, String pCategoryId) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.pCategoryId = pCategoryId;
	}
	public Category() {
		super();
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getpCategoryId() {
		return pCategoryId;
	}
	public void setpCategoryId(String pCategoryId) {
		this.pCategoryId = pCategoryId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
