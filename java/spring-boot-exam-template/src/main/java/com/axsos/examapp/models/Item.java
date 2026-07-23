package com.axsos.examapp.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/*
 * IMPORTANT FOR THE EXAM:
 *
 * Item هو الاسم العام.
 * إذا السؤال Game:
 * 1. غيّر اسم الملف Item.java إلى Game.java
 * 2. غيّر class Item إلى class Game
 * 3. غيّر table إلى games
 * 4. غيّر كل Item إلى Game في Repository, Service, Controller و JSP
 *
 * إذا السؤال Book اعمل نفس الخطوات واستبدل Item بـ Book.
 */
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * بدّل name حسب السؤال:
     * Game -> title أو name
     * Book -> title
     * Product -> name
     */
    @NotBlank(message = "Name is required.")
    @Size(min = 2, max = 100)
    private String name;

    /*
     * هذا Field ثاني عام.
     * ممكن تغيّره إلى genre, author, description, brand...
     */
    @NotBlank(message = "Description is required.")
    @Size(min = 3, max = 500)
    @Column(length = 500)
    private String description;

    /*
     * هذا Field رقمي عام.
     * ممكن يصير price, year, quantity, rating...
     */
    @NotNull(message = "Value is required.")
    private Double value;

    /*
     * كل Item له Owner واحد.
     * هذه العلاقة مفيدة إذا كل مستخدم ينشئ أغراضه.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
