package com.delivery.services.objects;

import com.delivery.dao.CityEntityDao;
import com.delivery.db.CityEntity;

public class CityEntityService {

    private final CityEntityDao cityEntityDao;

    public CityEntityService(CityEntityDao cityEntityDao) {
        this.cityEntityDao = cityEntityDao;
    }

    public CityEntity getById(int id) {
        return cityEntityDao.getById(id);
    }
    boolean save(CityEntity cityEntity) {
        return cityEntityDao.save(cityEntity);
    }
}
