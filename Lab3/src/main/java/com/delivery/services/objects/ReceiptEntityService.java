package com.delivery.services.objects;

import com.delivery.dao.ReceiptEntityDao;
import com.delivery.db.ReceiptEntity;

public class ReceiptEntityService {

    private ReceiptEntityDao receiptEntityDao;

    public ReceiptEntityService(ReceiptEntityDao receiptEntityDao) {
        this.receiptEntityDao = receiptEntityDao;
    }

    public ReceiptEntity getById(int id) {
        return receiptEntityDao.getById(id);
    }

    public ReceiptEntity getByDeliveryRequestId(int id) {
        return receiptEntityDao.getByDeliveryRequestId(id);
    }

    public boolean save(ReceiptEntity receiptEntity) {
        return receiptEntityDao.save(receiptEntity);
    }
}
