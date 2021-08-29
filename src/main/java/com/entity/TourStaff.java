package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tour_staff")
public class TourStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name = "id_person_info")
    private PersonInfo id_person_info;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_position")
    private Position id_position;

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

    public Position getId_position() {
        return id_position;
    }

    public void setId_position(Position id_position) {
        this.id_position = id_position;
    }
}