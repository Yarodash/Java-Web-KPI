package com.delivery.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "receipt", schema = "delivery", catalog = "")
public class ReceiptEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "delivery_request_id")
    private int deliveryRequestId;
    @Basic
    @Column(name = "is_payed")
    private byte isPayed;
    @Basic
    @Column(name = "manager_id")
    private int managerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeliveryRequestId() {
        return deliveryRequestId;
    }

    public void setDeliveryRequestId(int deliveryRequestId) {
        this.deliveryRequestId = deliveryRequestId;
    }

    public byte getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(byte isPayed) {
        this.isPayed = isPayed;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptEntity that = (ReceiptEntity) o;
        return id == that.id && deliveryRequestId == that.deliveryRequestId && isPayed == that.isPayed && managerId == that.managerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deliveryRequestId, isPayed, managerId);
    }
}
