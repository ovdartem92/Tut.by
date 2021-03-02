package by.tut.ta.framework.configuration;

import by.tut.ta.framework.browser.BrowserType;
import by.tut.ta.framework.logging.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyManager {
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        ClassLoader classLoader = PropertyManager.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("app.properties");
        try {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            Log.error(e.getMessage(), e);
        }
    }

    private PropertyManager() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", PropertyManager.class));
    }

    public static String getUrl() {
        return PROPERTIES.getProperty("home.url");
    }

    public static String getEmail() {
        return PROPERTIES.getProperty("email");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("password");
    }

    public static BrowserType getBrowserType() {
        String browserType = PROPERTIES.getProperty("browser").toUpperCase();
        return BrowserType.valueOf(browserType);
    }
}
