package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "type_of_food")
public class TypeOfFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "type_of_food", unique=true)
    private String type_of_food;

    public Long getId() {
        return id;
    }

    public String getType_of_food() {
        return type_of_food;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType_of_food(String type_of_food) {
        this.type_of_food = type_of_food;
    }

    @Override
    public String toString() {
        return getId() + " " + getType_of_food();
    }
}
