package com.delivery.dao;

import com.delivery.db.DeclineReasonEntity;

public interface DeclineReasonEntityDao {
    DeclineReasonEntity getByDeliveryRequestId(int id);
    boolean save(DeclineReasonEntity declineReasonEntity);
}
