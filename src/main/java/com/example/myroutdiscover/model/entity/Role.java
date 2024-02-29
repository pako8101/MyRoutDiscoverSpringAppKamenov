package com.example.myroutdiscover.model.entity;

import com.example.myroutdiscover.model.enums.RoleNameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;

    public Role() {
    }

    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }
}
