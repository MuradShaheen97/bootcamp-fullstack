package com.axsos.SpringBoot.Burger.Models;

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
import jakarta.validation.constraints.*;

@Entity
@Table(name="Burgers")
public class Burgers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, max=20,message = "The Name can not be empty, enter at lease 3 lettr word.")
	private String name;
	
	@NotNull
	@Size(min=3, max=20,message = "The Resturant Name can not be empty, enter at lease 3 lettr word.")
	private String resturantName;
	
	@NotNull(message = "Rating cannot be left blank.")
    @Min(value = 1, message = "The rating must be at least 1 star.")
    @Max(value = 5, message = "The rating cannot be higher than 5 stars.")
    private Double rate;
	
	@NotNull
	@Size(min=3, max=255,message = "Notes can not be empty, enter at lease 3 lettr word.")
	private String notes;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	public Burgers() {
	}
	public Burgers(String name, String resturantName, Double rate, String notes) {

		this.name = name;
		this.resturantName = resturantName;
		this.rate = rate;
		this.notes = notes;
	}

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

	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
