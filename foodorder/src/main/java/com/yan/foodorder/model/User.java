package com.yan.foodorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	private String name;
	private String email;
	private String password;
	
		
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return this.getId().equals(((User) obj).getId());
		}else {
			return false;
		}
	}	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", type=" + type + "]";
	}

	enum Type{
		admin,staff,manager,online_user,kitchen_staff
		}

}
