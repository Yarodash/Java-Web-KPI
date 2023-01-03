package com.delivery.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "travel", schema = "delivery", catalog = "")
public class TravelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "from_city_id")
    private int fromCityId;
    @Basic
    @Column(name = "to_city_id")
    private int toCityId;
    @Basic
    @Column(name = "distance")
    private int distance;
    @Basic
    @Column(name = "price_per_kg")
    private int pricePerKg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(int fromCityId) {
        this.fromCityId = fromCityId;
    }

    public int getToCityId() {
        return toCityId;
    }

    public void setToCityId(int toCityId) {
        this.toCityId = toCityId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(int pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelEntity that = (TravelEntity) o;
        return id == that.id && fromCityId == that.fromCityId && toCityId == that.toCityId && distance == that.distance && pricePerKg == that.pricePerKg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromCityId, toCityId, distance, pricePerKg);
    }
}
