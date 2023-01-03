package com.delivery.dao;

import com.delivery.db.UserEntity;

public interface UserEntityDao {
    UserEntity getById(int id);
    UserEntity getByLogin(String login);
    boolean save(UserEntity userEntity);
}
