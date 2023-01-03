package com.delivery.dao;

import com.delivery.db.ReceiptEntity;

public interface ReceiptEntityDao {
    ReceiptEntity getById(int id);
    ReceiptEntity getByDeliveryRequestId(int id);
    boolean save(ReceiptEntity receiptEntity);
}
