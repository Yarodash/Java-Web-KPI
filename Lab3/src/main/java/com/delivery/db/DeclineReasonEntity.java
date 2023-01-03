package com.delivery.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "decline_reason", schema = "delivery", catalog = "")
public class DeclineReasonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "delivery_request_id")
    private int deliveryRequestId;
    @Basic
    @Column(name = "manager_id")
    private int managerId;
    @Basic
    @Column(name = "comment")
    private String comment;

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

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclineReasonEntity that = (DeclineReasonEntity) o;
        return id == that.id && deliveryRequestId == that.deliveryRequestId && managerId == that.managerId && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deliveryRequestId, managerId, comment);
    }
}
