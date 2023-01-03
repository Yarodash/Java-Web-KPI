package com.delivery.log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class DeliveryLoggerFile implements DeliveryLogger {

    private Level currentLevel;
    private String filePath;

    public DeliveryLoggerFile(String filePath) {
        currentLevel = Level.INFO;
        this.filePath = filePath;
    }

    @Override
    public void setLevel(Level level) {
        currentLevel = level;
    }

    @Override
    public void log(Level level, String message) {
        if (level.ordinal() > currentLevel.ordinal())
            return;

        try
        {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(LocalDateTime.now() + " " + level.name() + ": " + message + "\n");
            fw.close();
        }
        catch (IOException ignored) {
            System.out.println("FILE LOGGER BROKEN!");
        }
    }
}
