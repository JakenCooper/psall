package com.jaken.psall.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="t_article")
public class Article {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="is_star")
	private boolean isStar;
	@Column(name="user_ud")
	private String userId;
	@Column(name="category_id")
	private String categoryId;
	@Column(name="create_time")
	private Date createTime;
	
	@Transient
	private String isStarMy;
	@Transient
	private Category category;
	@Transient
	private User user;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isStar() {
		return isStar;
	}
	public void setStar(boolean isStar) {
		this.isStar = isStar;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIsStarMy() {
		return isStarMy;
	}
	public void setIsStarMy(String isStarMy) {
		this.isStarMy = isStarMy;
	}
}
