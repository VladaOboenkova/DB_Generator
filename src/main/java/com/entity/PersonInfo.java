package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person_info", uniqueConstraints =
@UniqueConstraint(columnNames = { "intl_passport_num", "intl_passport_series" }))
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middle_name;

    @NotNull
    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "phone", unique=true)
    private String phone;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "intl_passport_num")
    private String intl_passport_num;

    @Column(name = "intl_passport_series")
    private String intl_passport_series;

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIntl_passport_num(String intl_passport_num) {
        this.intl_passport_num = intl_passport_num;
    }

    public void setIntl_passport_series(String intl_passport_series) {
        this.intl_passport_series = intl_passport_series;
    }

    public String getEmail() {
        return email;
    }

    public String getIntl_passport_num() {
        return intl_passport_num;
    }

    public String getIntl_passport_series() {
        return intl_passport_series;
    }

    @Override
    public String toString() {
        return getId() + " " + getSurname()  +
                " " + getName() + " " + getMiddle_name() + " " +
                getDob() + " " + getPhone() + " " + getEmail() + " " +
                getIntl_passport_num() + " " + getIntl_passport_series();
    }
}
