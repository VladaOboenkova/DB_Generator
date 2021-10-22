package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tour_add_service", uniqueConstraints =
@UniqueConstraint(columnNames = { "id_tour", "id_add_service" }))
public class TourAddService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_tour")
    private Tour id_tour;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_add_service")
    private AddService id_add_service;

    public Tour getId_tour() {
        return id_tour;
    }

    public void setId_tour(Tour id_tour) {
        this.id_tour = id_tour;
    }

    public AddService getId_add_service() {
        return id_add_service;
    }

    public void setId_add_service(AddService id_add_service) {
        this.id_add_service = id_add_service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}