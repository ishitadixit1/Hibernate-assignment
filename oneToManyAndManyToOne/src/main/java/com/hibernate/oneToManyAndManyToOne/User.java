package com.hibernate.oneToManyAndManyToOne;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@Column(name="id")
	private int userId;
	
	private String userName;
	
	@OneToMany(mappedBy = "user")
	private List<Orders> order;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
