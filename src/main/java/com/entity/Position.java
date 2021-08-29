package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "position_name", unique=true)
    private String position_name;

    @NotNull
    @Column(name = "salary")
    private BigDecimal salary;

    public Long getId() {
        return id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getId() + " " + getPosition_name() + " " + getSalary();
    }
}
