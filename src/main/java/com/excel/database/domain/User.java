package com.excel.database.domain;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    private Long id;
    private String weight;
    private String height;

    public User( ) {

    }

    public User(Long id, String weight, String height) {
        this.id = id;
        this.weight = weight;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
