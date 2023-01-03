package com.delivery.services;

import com.delivery.Dependencies;
import com.delivery.db.DeliveryRequestEntity;
import com.delivery.db.TravelEntity;
import com.delivery.db.UserEntity;

import java.sql.Timestamp;
import java.time.Instant;

public class MakeOrder {
    public static boolean make(UserEntity user, TravelEntity travelEntity, int weight, int volume) {
        int price = PriceCalculator.calculate_price(travelEntity, weight, volume);

        DeliveryRequestEntity deliveryRequestEntity = new DeliveryRequestEntity();
        deliveryRequestEntity.setUserId(user.getId());
        deliveryRequestEntity.setTravelId(travelEntity.getId());
        deliveryRequestEntity.setWeight(weight);
        deliveryRequestEntity.setVolume(volume);
        deliveryRequestEntity.setPrice(price);
        deliveryRequestEntity.setCreateTime(Timestamp.from(Instant.now()));

        return Dependencies.deliveryRequestEntityService.save(deliveryRequestEntity);
    }
}
