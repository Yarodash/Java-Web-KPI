package com.delivery.dao;

import com.delivery.db.UserEntity;
import com.delivery.utils.EntityManagerUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UserEntityDaoDB implements UserEntityDao {
    @Override
    public UserEntity getById(int id) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM user WHERE id=:id", UserEntity.class)
                .setParameter("id", id);
        try {
            return (UserEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }
    @Override
    public UserEntity getByLogin(String login) {
        Query query = EntityManagerUtils.getEntityManager().createNativeQuery("SELECT * FROM user WHERE login=:login", UserEntity.class)
                .setParameter("login", login);

        try {
            return (UserEntity) query.getSingleResult();
        } catch (NoResultException ignored) {
            return null;
        }
    }

    @Override
    public boolean save(UserEntity userEntity) {
        return EntityManagerUtils.save(userEntity);
    }
}
