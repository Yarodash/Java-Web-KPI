package com.delivery.services;

import com.delivery.db.TravelEntity;

public class PriceCalculator {
    public static int calculate_price(TravelEntity travelEntity, int weight, int volume) {
        return travelEntity.getPricePerKg() * weight;
    }
}
