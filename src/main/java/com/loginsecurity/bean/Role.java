package com.loginsecurity.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Column(unique = true)
	private String name;
	
	/*
	 * @OneToMany(mappedBy = "role") private Set<User> users;
	 */	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	public Role() {
		name = "USER";
	}
	public Role(String name) {
		this.name = name;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Set<User> getUsers()
	{
		return users;
	}
	public void setUsers(Set<User> users)
	{
		this.users = users;
	}

}
