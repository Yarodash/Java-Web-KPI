package com.delivery.db;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "delivery_request", schema = "delivery", catalog = "")
public class DeliveryRequestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "travel_id")
    private int travelId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "volume")
    private int volume;
    @Basic
    @Column(name = "weight")
    private int weight;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryRequestEntity that = (DeliveryRequestEntity) o;
        return id == that.id && travelId == that.travelId && userId == that.userId && volume == that.volume && weight == that.weight && price == that.price && Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, travelId, userId, volume, weight, price, createTime);
    }
}
