package com.delivery.dao;

import com.delivery.db.DeclineReasonEntity;
import com.delivery.utils.EntityManagerUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class DeclineReasonEntityDaoDB implements DeclineReasonEntityDao {

    @Override
    public DeclineReasonEntity getByDeliveryRequestId(int id) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM decline_reason WHERE decline_reason.delivery_request_id=:id", DeclineReasonEntity.class)
                .setParameter("id", id);

        try {
            return (DeclineReasonEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public boolean save(DeclineReasonEntity declineReasonEntity) {
        return EntityManagerUtils.save(declineReasonEntity);
    }
}
