package com.delivery.log;

public interface DeliveryLogger {

    enum Level {
        INFO, WARNING;
    }

    void setLevel(Level level);

    void log(Level level, String message);

}
