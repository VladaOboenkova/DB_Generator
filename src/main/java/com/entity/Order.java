package com.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_client")
    private Client id_client;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_tour")
    private Tour id_tour;

    @NotNull
    @Column(name = "departure_date")
    private LocalDate departure_date;

    @NotNull
    @Column(name = "number_of_nights")
    private Integer number_of_nights;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_tour_staff")
    private TourStaff id_tour_staff;

    @NotNull
    @Column(name = "order_date_time")
    private LocalDateTime order_date_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    public Tour getId_tour() {
        return id_tour;
    }

    public void setId_tour(Tour id_tour) {
        this.id_tour = id_tour;
    }

    public LocalDate getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
        this.departure_date = departure_date;
    }

    public Integer getNumber_of_nights() {
        return number_of_nights;
    }

    public void setNumber_of_nights(Integer number_of_nights) {
        this.number_of_nights = number_of_nights;
    }

    public TourStaff getId_tour_staff() {
        return id_tour_staff;
    }

    public void setId_tour_staff(TourStaff id_tour_staff) {
        this.id_tour_staff = id_tour_staff;
    }

    public LocalDateTime getOrder_date_time() {
        return order_date_time;
    }

    public void setOrder_date_time(LocalDateTime order_date_time) {
        this.order_date_time = order_date_time;
    }
}
