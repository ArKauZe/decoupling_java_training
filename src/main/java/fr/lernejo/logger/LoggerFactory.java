package fr.lernejo.logger;

import java.util.function.Predicate;
public class LoggerFactory {
    public static Logger getLogger(String name) {
        Predicate<String> condition = message -> message.contains("simulation");
        return new ContextualLogger(name,
            new CompositeLogger(new ConsoleLogger(),
                new FilteredLogger(new FileLogger("logs"), condition)));

    }
}
