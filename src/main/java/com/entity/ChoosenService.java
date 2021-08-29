package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "choosen_service")
public class ChoosenService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order id_order;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_add_service")
    private AddService id_add_service;

    @NotNull
    @Column(name = "amount")
    private Integer amount;

    public Order getId_order() {
        return id_order;
    }

    public void setId_order(Order id_order) {
        this.id_order = id_order;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}