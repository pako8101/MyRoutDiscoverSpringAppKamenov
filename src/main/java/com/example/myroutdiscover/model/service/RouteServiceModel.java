package com.example.myroutdiscover.model.service;

import com.example.myroutdiscover.model.entity.Category;
import com.example.myroutdiscover.model.entity.Picture;
import com.example.myroutdiscover.model.entity.User;
import com.example.myroutdiscover.model.entity.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.Set;

public class RouteServiceModel {

    private Long id;
    private String gpxCoordinates;

    private LevelEnum level;

    private String name;

    private User author;

    private String videoUrl;

    private String description;

    private Set<Picture> pictures;

    private Set<Category> categories;

    public RouteServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
