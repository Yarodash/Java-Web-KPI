package com.delivery.log;

public class DeliveryLoggerMultiple implements DeliveryLogger {

    private final DeliveryLogger logger1;
    private final DeliveryLogger logger2;

    public DeliveryLoggerMultiple(DeliveryLogger logger1, DeliveryLogger logger2) {
        this.logger1 = logger1;
        this.logger2 = logger2;
    }

    @Override
    public void setLevel(Level level) {
        logger1.setLevel(level);
        logger2.setLevel(level);
    }

    @Override
    public void log(Level level, String message) {
        logger1.log(level, message);
        logger2.log(level, message);
    }
}
