package com.delivery.dao;

import com.delivery.db.TravelEntity;

import java.util.List;

public interface TravelEntityDao {
    List<TravelEntity> getAll(String orderBy);
    TravelEntity getById(int id);
    boolean save(TravelEntity travelEntity);
}
