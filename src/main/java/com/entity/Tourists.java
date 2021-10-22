package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tourists", uniqueConstraints =
@UniqueConstraint(columnNames = { "id_order", "id_person_info" }))
public class Tourists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order id_order;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_person_info")
    private PersonInfo id_person_info;

    public Order getId_order() {
        return id_order;
    }

    public void setId_order(Order id_order) {
        this.id_order = id_order;
    }

    public PersonInfo getId_person_info() {
        return id_person_info;
    }

    public void setId_person_info(PersonInfo id_person_info) {
        this.id_person_info = id_person_info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
