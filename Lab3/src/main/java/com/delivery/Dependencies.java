package com.delivery;

import com.delivery.dao.*;
import com.delivery.log.DeliveryLogger;
import com.delivery.log.DeliveryLoggerConsole;
import com.delivery.log.DeliveryLoggerFile;
import com.delivery.log.DeliveryLoggerMultiple;
import com.delivery.services.objects.*;

public class Dependencies {
    public static CityEntityDao cityEntityDao = new CityEntityDaoDB();
    public static TravelEntityDao travelEntityDao = new TravelEntityDaoDB();
    public static ReceiptEntityDao receiptEntityDao = new ReceiptEntityDaoDB();
    public static UserEntityDao userEntityDao = new UserEntityDaoDB();
    public static DeclineReasonEntityDao declineReasonEntityDao = new DeclineReasonEntityDaoDB();
    public static DeliveryRequestEntityDao deliveryRequestEntityDao = new DeliveryRequestEntityDaoDB();

    public static CityEntityService cityEntityService = new CityEntityService(cityEntityDao);
    public static TravelEntityService travelEntityService = new TravelEntityService(travelEntityDao);
    public static ReceiptEntityService receiptEntityService = new ReceiptEntityService(receiptEntityDao);
    public static UserEntityService userEntityService = new UserEntityService(userEntityDao);
    public static DeclineReasonEntityService declineReasonEntityService = new DeclineReasonEntityService(declineReasonEntityDao);
    public static DeliveryRequestEntityService deliveryRequestEntityService = new DeliveryRequestEntityService(deliveryRequestEntityDao);

    public static DeliveryLogger deliveryLogger = new DeliveryLoggerMultiple(new DeliveryLoggerConsole(), new DeliveryLoggerFile("D:/Labs/Java-Web-KPI/log.txt"));
}
