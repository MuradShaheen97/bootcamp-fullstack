package com.axsos.BooksAPI.models;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 5, max = 200)
	private String title;

	@NotNull
	@Size(min = 5, max = 200)
	private String description;

	@NotNull
	@Size(min = 5, max = 200)
	private String language;

	@NotNull
	private Integer pages;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Books() {
	}

	public Books(String title, String description, String language, Integer pages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.pages = pages;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public Integer getPages() {
		return pages;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
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