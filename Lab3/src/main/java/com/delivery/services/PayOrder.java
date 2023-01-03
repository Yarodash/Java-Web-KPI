package com.delivery.services;

import com.delivery.Dependencies;
import com.delivery.db.ReceiptEntity;
import com.delivery.log.DeliveryLogger;

public class PayOrder {
    public static boolean pay(ReceiptEntity receiptEntity) {
        if (receiptEntity.getIsPayed() == (byte) 1) {
            Dependencies.deliveryLogger.log(DeliveryLogger.Level.INFO, "Receipt #" + receiptEntity.getId() + " was payed.");
            return true;
        }

        receiptEntity.setIsPayed((byte) 1);
        return Dependencies.receiptEntityService.save(receiptEntity);
    }
}
