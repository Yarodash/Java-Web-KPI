package com.delivery.services;

import com.delivery.Dependencies;
import com.delivery.db.DeclineReasonEntity;
import com.delivery.db.DeliveryRequestEntity;
import com.delivery.db.UserEntity;

public class DeclineReceipt {
    public static boolean decline(DeliveryRequestEntity deliveryRequest, UserEntity manager, String comment) {
        DeclineReasonEntity declineReasonEntity = new DeclineReasonEntity();
        declineReasonEntity.setDeliveryRequestId(deliveryRequest.getId());
        declineReasonEntity.setManagerId(manager.getId());
        declineReasonEntity.setComment(comment);

        return Dependencies.declineReasonEntityService.save(declineReasonEntity);
    }
}
