package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @NotNull
    @Column(name = "visa")
    private Boolean visa;

    @NotNull
    @Column(name = "need_insurance")
    private Boolean need_insurance;

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

    public Boolean getVisa() {
        return visa;
    }

    public void setVisa(Boolean visa) {
        this.visa = visa;
    }

    public Boolean getNeed_insurance() {
        return need_insurance;
    }

    public void setNeed_insurance(Boolean need_insurance) {
        this.need_insurance = need_insurance;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " visa: " + getVisa() + " need_insurance: " + getNeed_insurance();
    }
}