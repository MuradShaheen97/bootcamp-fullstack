package com.axsos.exam.models;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * USER MODEL This class represents the users table in MySQL. It also contains
 * the validation rules used by the registration form.
 */
@Entity
@Table(name = "users")
public class User {

	// Primary key: MySQL creates the id automatically.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "First name is required")
	@Size(min = 8, max = 50, message = "First name must be between 8 and 50 characters")
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Size(min = 8, max = 50, message = "Last name must be between 8 and 50 characters")
	private String lastName;

	@NotBlank(message = "Email is required")
	@Email(message = "Please enter a valid email address")
	@Column(unique = true)
	private String email;

	// The encrypted BCrypt password is saved in the database.
	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 128, message = "Password must be at least 8 characters")
	private String password;

	// @Transient means this field is used by the form but is NOT saved in MySQL.
	@Transient
	@NotBlank(message = "Confirm password is required")
	private String confirm;

	// User must check the terms checkbox during registration.
	@Transient
	@AssertTrue(message = "You must accept the terms and conditions")
	private boolean acceptedTerms;

	@Column(updatable = false)
	private Date createdAt;

	private Date updatedAt;

	public User() {
	}

	// Runs automatically before the first INSERT query.
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	// Runs automatically before every UPDATE query.
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public boolean isAcceptedTerms() {
		return acceptedTerms;
	}

	public void setAcceptedTerms(boolean acceptedTerms) {
		this.acceptedTerms = acceptedTerms;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
