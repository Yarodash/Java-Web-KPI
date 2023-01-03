package com.delivery.dao;

import com.delivery.db.DeliveryRequestEntity;

import java.util.List;

public interface DeliveryRequestEntityDao {
    List<DeliveryRequestEntity> getAllByTime();
    DeliveryRequestEntity getById(int id);
    List<DeliveryRequestEntity> getByUserId(int user_id);
    List<DeliveryRequestEntity> getWithoutReceiptAndDecline();
    boolean save(DeliveryRequestEntity deliveryRequestEntity);
}
