package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "client", uniqueConstraints =
@UniqueConstraint(columnNames = { "passport_num", "passport_series" }))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(optional=false)
    @JoinColumn(name = "id_person_info")
    private PersonInfo id_person_info;

    @NotNull
    @Column(name = "passport_num")
    private String passport_num;

    @NotNull
    @Column(name = "passport_series")
    private String passport_series;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonInfo getId_person_info() {
        return id_person_info;
    }

    public void setId_person_info(PersonInfo id_person_info) {
        this.id_person_info = id_person_info;
    }

    public String getPassport_num() {
        return passport_num;
    }

    public void setPassport_num(String passport_num) {
        this.passport_num = passport_num;
    }

    public String getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(String passport_series) {
        this.passport_series = passport_series;
    }

}