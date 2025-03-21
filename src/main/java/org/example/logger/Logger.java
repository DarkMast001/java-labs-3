package org.example.logger;

import java.time.LocalDate;

public interface Logger {
    default void debug(String msg) {
        log(msg, "DEBUG");
    }

    default void info(String msg) {
        log(msg, "INFO");
    }

    default void warn(String msg) {
        log(msg, "WARN");
    }

    default void error(String msg) {
        log(msg, "ERROR");
    }

    default void epicFail(String msg) {
        log(msg, "EPIC_FAIL");
    }

    private void log(String msg, String lvl) {
        System.out.println("Dummy logger, " + LocalDate.now());
        System.out.println("Level: " + lvl);
        System.out.println("Message: " + msg);
    }
}
