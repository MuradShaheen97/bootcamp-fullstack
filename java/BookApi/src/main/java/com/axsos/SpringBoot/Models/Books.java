package com.axsos.SpringBoot.Models;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;


@Entity
@Table(name = "Books")
public class Books {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	@Size(min=2 , max = 15)
	private String title ;
	
	@NotNull
	@Size(min=2 , max = 255)
	private String descreption ;
	
	@NotNull
	@Size(min=2 , max = 15)
	private String language ;
	
	@NotNull
	@Min(8)
	private Integer pages ;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Books( String title, String descreption, String language, Integer pages) {

		this.title = title;
		this.descreption = descreption;
		this.language = language;
		this.pages = pages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();

}
}