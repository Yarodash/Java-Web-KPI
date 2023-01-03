package com.delivery.services;

import com.delivery.Dependencies;
import com.delivery.db.DeliveryRequestEntity;
import com.delivery.db.ReceiptEntity;
import com.delivery.db.UserEntity;

public class MakeReceipt {
    public static boolean make(DeliveryRequestEntity deliveryRequest, UserEntity manager) {
        ReceiptEntity receiptEntity = new ReceiptEntity();
        receiptEntity.setDeliveryRequestId(deliveryRequest.getId());
        receiptEntity.setManagerId(manager.getId());

        return Dependencies.receiptEntityService.save(receiptEntity);
    }
}
