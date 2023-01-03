package com.delivery.dao;

import com.delivery.db.DeliveryRequestEntity;
import com.delivery.utils.EntityManagerUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRequestEntityDaoDB implements DeliveryRequestEntityDao {
    @Override
    public List<DeliveryRequestEntity> getAllByTime() {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery(
                "SELECT * FROM delivery_request ORDER BY delivery_request.create_time DESC",
                DeliveryRequestEntity.class);
        List<DeliveryRequestEntity> result = new ArrayList<>();
        for (Object i : query.getResultList()) {
            result.add((DeliveryRequestEntity) i);
        }
        return result;
    }

    @Override
    public DeliveryRequestEntity getById(int id) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM delivery_request WHERE id=:id", DeliveryRequestEntity.class)
                .setParameter("id", id);

        try {
            return (DeliveryRequestEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public List<DeliveryRequestEntity> getByUserId(int user_id) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM delivery_request WHERE user_id=:user_id ORDER BY delivery_request.create_time DESC", DeliveryRequestEntity.class)
                .setParameter("user_id", user_id);
        List<DeliveryRequestEntity> result = new ArrayList<>();
        for (Object i : query.getResultList()) {
            result.add((DeliveryRequestEntity) i);
        }
        return result;
    }

    @Override
    public List<DeliveryRequestEntity> getWithoutReceiptAndDecline() {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery(
                "SELECT * FROM delivery_request WHERE id NOT IN (SELECT delivery_request.id FROM delivery_request INNER JOIN receipt ON delivery_request.id = receipt.delivery_request_id) AND id NOT IN (SELECT delivery_request.id FROM delivery_request INNER JOIN decline_reason ON delivery_request.id = decline_reason.delivery_request_id) ORDER BY delivery_request.create_time DESC",
                DeliveryRequestEntity.class);
        List<DeliveryRequestEntity> result = new ArrayList<>();
        for (Object i : query.getResultList()) {
            result.add((DeliveryRequestEntity) i);
        }
        return result;
    }

    @Override
    public boolean save(DeliveryRequestEntity deliveryRequestEntity) {
        return EntityManagerUtils.save(deliveryRequestEntity);
    }
}
