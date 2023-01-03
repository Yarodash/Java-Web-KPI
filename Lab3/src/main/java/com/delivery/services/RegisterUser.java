package com.delivery.services;

import com.delivery.Dependencies;
import com.delivery.db.UserEntity;
import com.delivery.log.DeliveryLogger;

public class RegisterUser {
    public static boolean register(String login, String password) {

        UserEntity userEntity = Dependencies.userEntityService.getByLogin(login);

        if (userEntity != null) {
            return false;
        }

        if (login.length() <= 6 || password.length() <= 6) {
            return false;
        }

        userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(password);
        userEntity.setIsAdmin((byte) 0);

        if (Dependencies.userEntityService.save(userEntity)) {
            Dependencies.deliveryLogger.log(DeliveryLogger.Level.INFO, "User " + login + " registered.");
            return true;
        }

        Dependencies.deliveryLogger.log(DeliveryLogger.Level.WARNING, "Error while registration.");
        return false;
    }
}
