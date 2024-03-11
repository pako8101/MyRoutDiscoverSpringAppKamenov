package com.example.myroutdiscover.model.view;

import com.example.myroutdiscover.model.entity.Category;
import com.example.myroutdiscover.model.entity.Picture;
import com.example.myroutdiscover.model.entity.User;
import com.example.myroutdiscover.model.entity.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.Set;

public class RouteDetailsViewModel {

    private String gpxCoordinates;
    private LevelEnum level;
    private String name;
    private String videoUrl;
    private String description;
    private Set<Picture> pictures;

    public RouteDetailsViewModel() {
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
}
