package com.example.myroutdiscover.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity {
    @Column(nullable = false)
    private boolean Approved;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private Route route;
    @ManyToOne
    private User user;
    @Column(name = "created",nullable = false)
    private LocalDateTime created;

    public Comments() {
    }

    public boolean isApproved() {
        return Approved;
    }

    public void setApproved(boolean approved) {
        Approved = approved;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
