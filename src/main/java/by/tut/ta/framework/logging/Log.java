package by.tut.ta.framework.logging;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.net.URL;
import java.util.Objects;

import static java.lang.String.format;

public class Log {
    public static final String MESSAGE_CANNOT_BE_NULL = "Message cannot be null.";
    private static final Logger LOGGER = Logger.getLogger("custom-logger");

    static {
        URL resource = Log.class.getClassLoader().getResource("log4j.properties");
        String absolutePath = Objects.requireNonNull(resource).getPath();
        PropertyConfigurator.configureAndWatch(absolutePath);
    }

    private Log() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", Log.class));
    }

    public static void addAppender(Appender appender) {
        Objects.requireNonNull(appender, "Appender cannot be null.");
        LOGGER.addAppender(appender);
    }

    public static void removeAppender(Appender appender) {
        Objects.requireNonNull(appender, "Appender cannot be null.");
        LOGGER.removeAppender(appender);
    }

    public static void trace(Object message) {
        Objects.requireNonNull(message, MESSAGE_CANNOT_BE_NULL);
        LOGGER.trace(message);
    }

    public static void debug(Object message) {
        Objects.requireNonNull(message, MESSAGE_CANNOT_BE_NULL);
        LOGGER.debug(message);
    }

    public static void info(Object message) {
        Objects.requireNonNull(message, MESSAGE_CANNOT_BE_NULL);
        LOGGER.info(message);
    }

    public static void warn(Object message) {
        Objects.requireNonNull(message, MESSAGE_CANNOT_BE_NULL);
        LOGGER.warn(message);
    }

    public static void error(Object message, Throwable exception) {
        Objects.requireNonNull(message, MESSAGE_CANNOT_BE_NULL);
        Objects.requireNonNull(exception, "Exception cannot be null.");
        LOGGER.error(message, exception);
    }

    public static void fatal(Object message, Throwable exception) {
        Objects.requireNonNull(message, MESSAGE_CANNOT_BE_NULL);
        Objects.requireNonNull(exception, "Exception cannot be null.");
        LOGGER.fatal(message, exception);
    }
}
