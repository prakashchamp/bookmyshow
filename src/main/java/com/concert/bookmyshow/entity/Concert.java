package com.concert.bookmyshow.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "concert")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String venue;

    public Concert(){}

    public Concert(String title, double price, String venue) {
        this.title = title;
        this.price = price;
        this.venue = venue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getVenue() {
        return venue;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
