package com.mccorby.ioc_game;

import ioc_container.Logger;

public class SystemOutLogger implements Logger {
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
