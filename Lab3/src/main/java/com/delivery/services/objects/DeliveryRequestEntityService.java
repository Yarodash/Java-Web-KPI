package com.delivery.services.objects;

import com.delivery.Dependencies;
import com.delivery.dao.DeliveryRequestEntityDao;
import com.delivery.db.DeclineReasonEntity;
import com.delivery.db.DeliveryRequestEntity;
import com.delivery.db.ReceiptEntity;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRequestEntityService {

    private final DeliveryRequestEntityDao deliveryRequestEntityDao;

    public DeliveryRequestEntityService(DeliveryRequestEntityDao deliveryRequestEntityDao) {
        this.deliveryRequestEntityDao = deliveryRequestEntityDao;
    }

    public List<DeliveryRequestEntity> getAllByTime() {
        return deliveryRequestEntityDao.getAllByTime();
    }
    public DeliveryRequestEntity getById(int id) {
        return deliveryRequestEntityDao.getById(id);
    }
    public List<DeliveryRequestEntity> getByUserId(int user_id) {
        return deliveryRequestEntityDao.getByUserId(user_id);
    }

    public List<DeliveryRequestEntity> getWithoutReceiptAndDecline() {
        List<DeliveryRequestEntity> deliveryRequestEntities = new ArrayList<>();
        for (DeliveryRequestEntity deliveryRequest: getAllByTime()) {
            if (Dependencies.receiptEntityService.getByDeliveryRequestId(deliveryRequest.getId()) == null &&
                Dependencies.declineReasonEntityService.getByDeliveryRequestId(deliveryRequest.getId()) == null) {
                deliveryRequestEntities.add(deliveryRequest);
            }
        }
        return deliveryRequestEntities;
    }
    public boolean save(DeliveryRequestEntity deliveryRequestEntity) {
        return deliveryRequestEntityDao.save(deliveryRequestEntity);
    }

    public ReceiptEntity getReceipt(DeliveryRequestEntity deliveryRequest) {
        return Dependencies.receiptEntityService.getByDeliveryRequestId(deliveryRequest.getId());
    }

    public DeclineReasonEntity getDeclineReason(DeliveryRequestEntity deliveryRequest) {
        return Dependencies.declineReasonEntityService.getByDeliveryRequestId(deliveryRequest.getId());
    }
}
