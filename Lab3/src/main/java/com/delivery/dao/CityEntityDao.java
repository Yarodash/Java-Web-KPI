package com.delivery.dao;

import com.delivery.db.CityEntity;

public interface CityEntityDao {
    CityEntity getById(int id);
    boolean save(CityEntity cityEntity);
}
