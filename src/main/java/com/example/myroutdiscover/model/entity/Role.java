package com.example.myroutdiscover.model.entity;

import com.example.myroutdiscover.model.entity.enums.RoleNameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleNameEnum role;

    public Role() {
    }

    public RoleNameEnum getRole() {
        return role;
    }

    public void setRole(RoleNameEnum role) {
        this.role = role;
    }
}
