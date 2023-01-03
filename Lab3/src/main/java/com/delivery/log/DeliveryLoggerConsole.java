package com.delivery.log;

import java.time.LocalDateTime;

public class DeliveryLoggerConsole implements DeliveryLogger {

    private Level currentLevel;

    public DeliveryLoggerConsole() {
        currentLevel = Level.INFO;
    }

    public void setLevel(Level level) {
        currentLevel = level;
    }

    @Override
    public void log(Level level, String message) {
        if (level.ordinal() > currentLevel.ordinal())
            return;

        System.out.println(LocalDateTime.now() + " " + level.name() + ": " + message);
    }
}
