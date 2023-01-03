package com.delivery.dao;

import com.delivery.db.CityEntity;
import com.delivery.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class CityEntityDaoDB implements CityEntityDao {
    @Override
    public CityEntity getById(int id) {
        EntityManager entityManager = EntityManagerUtils.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM city WHERE id=:id", CityEntity.class)
                .setParameter("id", id);
        try {
            return (CityEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public boolean save(CityEntity cityEntity) {
        return EntityManagerUtils.save(cityEntity);
    }
}
