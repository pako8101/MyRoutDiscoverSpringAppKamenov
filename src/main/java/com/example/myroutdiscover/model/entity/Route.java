package com.example.myroutdiscover.model.entity;

import com.example.myroutdiscover.model.entity.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {
    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    private User author;
    @Column
    private String videoUrl;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "route",fetch = FetchType.EAGER)
    private Set<Picture>pictures;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

    public Route() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
