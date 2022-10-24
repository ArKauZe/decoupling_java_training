package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final Logger logger;
    private final String className;

    public ContextualLogger(String className, Logger logger) {
        this.logger = logger;
        this.className = className;
    }

    @Override
    public void log(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        logger.log(LocalDateTime.now().format(dtf) + " " + className + " " + message);
    }
}
