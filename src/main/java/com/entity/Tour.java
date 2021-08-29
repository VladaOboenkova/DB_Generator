package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(optional=false)
    @JoinColumn(name = "id_hotel")
    private Hotel id_hotel;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_type_of_food")
    private TypeOfFood id_type_of_food;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_type_of_room")
    private TypeOfRoom id_type_of_room;

    @NotNull
    @Column(name = "num_of_adults")
    private Integer num_of_adults;

    @NotNull
    @Column(name = "num_of_children")
    private Integer num_of_children;

    @NotNull
    @Column(name = "one_night_price")
    private BigDecimal one_night_price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Hotel id_hotel) {
        this.id_hotel = id_hotel;
    }

    public TypeOfFood getId_type_of_food() {
        return id_type_of_food;
    }

    public void setId_type_of_food(TypeOfFood id_type_of_food) {
        this.id_type_of_food = id_type_of_food;
    }

    public TypeOfRoom getId_type_of_room() {
        return id_type_of_room;
    }

    public void setId_type_of_room(TypeOfRoom id_type_of_room) {
        this.id_type_of_room = id_type_of_room;
    }

    public Integer getNum_of_adults() {
        return num_of_adults;
    }

    public void setNum_of_adults(Integer num_of_adults) {
        this.num_of_adults = num_of_adults;
    }

    public Integer getNum_of_children() {
        return num_of_children;
    }

    public void setNum_of_children(Integer num_of_children) {
        this.num_of_children = num_of_children;
    }

    public BigDecimal getOne_night_price() {
        return one_night_price;
    }

    public void setOne_night_price(BigDecimal one_night_price) {
        this.one_night_price = one_night_price;
    }
}
