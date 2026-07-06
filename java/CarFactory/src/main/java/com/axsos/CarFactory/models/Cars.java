package com.axsos.CarFactory.models;

import java.util.*;

import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Cars")

public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 2, max = 12, message = "the color must be from 2 caracters to 12")
	private String color;

	@NotNull
	@Size(min = 2, max = 30, message = "the company name must be from 2 caracters to 30")
	private String company;

	@NotNull
	@Size(min = 2, max = 20, message = "the models name must be from 2 caracters to 20")
	private String model;

	@NotNull
	@Size(min = 4, max = 6, message = "fill it desil or petrol")
	private String fule;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date carDate;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Cars(String color, String company, String model, String fule, Date carDate) {
		this.color = color;
		this.company = company;
		this.model = model;
		this.fule = fule;
		this.carDate = carDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFule() {
		return fule;
	}

	public void setFule(String fule) {
		this.fule = fule;
	}

	public Date getCarDate() {
		return carDate;
	}

	public void setCarDate(Date carDate) {
		this.carDate = carDate;
	}

	public Cars() {
		// TODO Auto-generated constructor stub
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
