package com.Group1.MealsOnWheels.Entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_id;
    private String meal_name;
    private String description;
    private String duration;

    @Column(nullable = true, length = 64)
    private String photo;

    @Column(nullable = true, length = 64)
    private String photoPath;

    public Meal() {

    }




    public Meal(Long m_id, String meal_name, String description, String duration, String photo, String photoPath) {
        super();
        this.m_id = m_id;
        this.meal_name = meal_name;
        this.description = description;
        this.duration = duration;
        this.photo = photo;
        this.photoPath = photoPath;
    }

    public Long getM_id() {
        return m_id;
    }
    public void setM_id(Long m_id) {
        this.m_id = m_id;
    }
    public String getMeal_name() {
        return meal_name;
    }
    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getPhotoPath() {
        return photoPath;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }




    @Override
    public String toString() {
        return "Meal [m_id=" + m_id + ", meal_name=" + meal_name + ", description=" + description + ", duration="
                + duration + ", photo=" + photo + ", photoPath=" + photoPath + "]";
    }



}
