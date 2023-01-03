package com.delivery.services.objects;

import com.delivery.dao.DeclineReasonEntityDao;
import com.delivery.db.DeclineReasonEntity;

public class DeclineReasonEntityService {

    private final DeclineReasonEntityDao declineReasonEntityDao;

    public DeclineReasonEntityService(DeclineReasonEntityDao declineReasonEntityDao) {
        this.declineReasonEntityDao = declineReasonEntityDao;
    }

    public DeclineReasonEntity getByDeliveryRequestId(int id) {
        return declineReasonEntityDao.getByDeliveryRequestId(id);
    }
    public boolean save(DeclineReasonEntity declineReasonEntity) {
        return declineReasonEntityDao.save(declineReasonEntity);
    }
}
