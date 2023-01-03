package com.delivery.services.objects;

import com.delivery.dao.UserEntityDao;
import com.delivery.db.UserEntity;

public class UserEntityService {

    private UserEntityDao userEntityDao;

    public UserEntityService(UserEntityDao userEntityDao) {
        this.userEntityDao = userEntityDao;
    }

    public UserEntity getById(int id) {
        return userEntityDao.getById(id);
    }

    public UserEntity getByLogin(String login) {
        return userEntityDao.getByLogin(login);
    }

    public boolean save(UserEntity userEntity) {
        return userEntityDao.save(userEntity);
    }

}
