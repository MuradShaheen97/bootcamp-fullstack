package com.axsos.driver.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Licenses")
public class Licenses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 2, max = 15, message = "put you car name or companny between 2 and 15 caracters")
	private String vichle;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateexpDate;

	@NotNull
	@Size(min = 2, max = 3, message = "you must tell us what your bolld symbole")
	private String bloodtype;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dirver_id")
	private Drivers driver;

	public Licenses(String vichle, Date dateexpDate, String bloodtype) {

		this.vichle = vichle;
		this.dateexpDate = dateexpDate;
		this.bloodtype = bloodtype;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVichle() {
		return vichle;
	}

	public void setVichle(String vichle) {
		this.vichle = vichle;
	}

	public Date getDateexpDate() {
		return dateexpDate;
	}

	public void setDateexpDate(Date dateexpDate) {
		this.dateexpDate = dateexpDate;
	}

	public String getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
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
