package com.training.app.model;

public class Trip {

    private Long id;
    private Place departure;
    private Place arrival;
    private float price;

    public Trip() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getDeparture() {
        return departure;
    }

    public void setDeparture(Place departure) {
        this.departure = departure;
    }

    public Place getArrival() {
        return arrival;
    }

    public void setArrival(Place arrival) {
        this.arrival = arrival;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", price=" + price +
                '}';
    }
}
