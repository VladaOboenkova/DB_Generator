package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @NotNull
    @Column(name = "one_day_price")
    private BigDecimal one_day_price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOne_day_price() {
        return one_day_price;
    }

    public void setOne_day_price(BigDecimal one_day_price) {
        this.one_day_price = one_day_price;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getOne_day_price();
    }
}