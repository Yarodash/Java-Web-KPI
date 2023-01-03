package com.delivery.services.objects;

import com.delivery.dao.TravelEntityDao;
import com.delivery.db.TravelEntity;

import java.util.List;

public class TravelEntityService {

    private final TravelEntityDao travelEntityDao;

    public TravelEntityService(TravelEntityDao travelEntityDao) {
        this.travelEntityDao = travelEntityDao;
    }

    public List<TravelEntity> getAll(String orderBy) {
        return travelEntityDao.getAll(orderBy);
    }
    public TravelEntity getById(int id) {
        return travelEntityDao.getById(id);
    }
    public boolean save(TravelEntity travelEntity) {
        return travelEntityDao.save(travelEntity);
    }
}
