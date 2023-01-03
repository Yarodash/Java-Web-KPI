package com.delivery.dao;

import com.delivery.db.TravelEntity;
import com.delivery.utils.EntityManagerUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TravelEntityDaoDB implements TravelEntityDao {
    @Override
    public List<TravelEntity> getAll(String orderBy) {

        String query_string = "SELECT * FROM travel";

        if (Objects.equals(orderBy, "distance")) {
            query_string = "SELECT * FROM travel ORDER BY travel.distance ASC";
        } else if (Objects.equals(orderBy, "from_city")) {
            query_string = "SELECT travel.* FROM travel INNER JOIN city on travel.from_city_id = city.id ORDER BY city.name ASC";
        } else if (Objects.equals(orderBy, "price")) {
            query_string = "SELECT * FROM travel ORDER BY travel.price_per_kg ASC";
        }

        Query query = EntityManagerUtils.getEntityManager().createNativeQuery(query_string, TravelEntity.class);
        List<TravelEntity> result = new ArrayList<>();
        for (Object i : query.getResultList()) {
            result.add((TravelEntity) i);
        }
        return result;
    }

    @Override
    public TravelEntity getById(int id) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM travel WHERE id=:id", TravelEntity.class)
                .setParameter("id", id);
        try {
            return (TravelEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public boolean save(TravelEntity travelEntity) {
        return EntityManagerUtils.save(travelEntity);
    }
}
