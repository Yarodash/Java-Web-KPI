package com.delivery.dao;

import com.delivery.db.ReceiptEntity;
import com.delivery.utils.EntityManagerUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class ReceiptEntityDaoDB implements ReceiptEntityDao {
    @Override
    public ReceiptEntity getById(int id) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM receipt WHERE id=:id", ReceiptEntity.class)
                .setParameter("id", id);
        try {
            return (ReceiptEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public ReceiptEntity getByDeliveryRequestId(int id) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM receipt WHERE receipt.delivery_request_id=:id", ReceiptEntity.class)
                .setParameter("id", id);

        try {
            return (ReceiptEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public boolean save(ReceiptEntity receiptEntity) {
        return EntityManagerUtils.save(receiptEntity);
    }
}
