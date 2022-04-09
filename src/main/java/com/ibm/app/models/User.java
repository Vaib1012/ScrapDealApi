package com.ibm.app.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;

	@NotBlank
	@Size(max = 20)
	@Column(name="username")
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name="email")
	private String email;

	@NotBlank
	@Size(max = 120)
	@Column(name="password")
	private String password;

	@NotBlank
	@Size(max = 120)
	@Column(name="firstname")
	private String firstname;
	
	@NotBlank
	@Size(max = 120)
	@Column(name="lastname")
	private String lastname;

	@OneToMany(mappedBy="user")
	private Set<Stock> savedStocks = new HashSet<>();

	@OneToMany(mappedBy="user")
	private Set<Post> savedPosts = new HashSet<>();

	public User() {
		
	}
	public User(String username, String email, String password, String firstname, String lastname) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public Set<Stock> getSavedStocks() {
		return savedStocks;
	}

	public void setSavedStocks(Set<Stock> savedStocks) {
		this.savedStocks = savedStocks;
	}
	public void addStock(Stock stock) {
		savedStocks.add(stock);
	}

	public Set<Post> getSavedPosts() {
		return savedPosts;
	}

	public void setSavedPosts(Set<Post> savedPosts) {
		this.savedPosts = savedPosts;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}



