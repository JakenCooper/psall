package com.jaken.psall.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity(name="t_user")
public class User {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="passwd")
	private String passwd;
	@Column(name="email")
	private String email;
	@Column(name="create_time")
	private Date createtime;
	@Column(name="is_use")
	@Type(type="yes_no")
	private boolean isUse;
	@Column(name="age")
	private Integer age;
	
	@Transient
	private String myIsUse;
	
	
	
	public User(String name) {
		super();
		this.name = name;
	}
	public User() {
		super();
	}
	@Transient
	private List<Category> categories;
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public boolean isUse() {
		return isUse;
	}
	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getMyIsUse() {
		return myIsUse;
	}
	public void setMyIsUse(String myIsUse) {
		this.myIsUse = myIsUse;
	}
	@Override
	public String toString() {
		return name;
	}
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		Collections.addAll(users, new User("小白"),new User("张岩松"),new User("pmlw"),new User("zzz"));
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println(users);
	}
}
