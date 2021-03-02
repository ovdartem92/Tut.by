package by.tut.ta.framework.ui.components;

import by.tut.ta.framework.browser.Browser;
import by.tut.ta.framework.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;

public class CommonPageElement {
    private static final String TIMEOUT_ERROR_MESSAGE = "Timeout in seconds cannot be less than 0.";
    private static final String LOCATOR_ERROR_MESSAGE = "Locator cannot be null.";
    private static final String ATTRIBUTE_ERROR_MESSAGE = "Attribute cannot be null.";
    private static final int TIMEOUT_IN_SECONDS = 10;
    private static final int POLLING_EVERY_MILLISECONDS = 500;
    protected By locator;

    private static Wait<? extends WebDriver> getCustomWait(int timeoutInSeconds) {
        assert timeoutInSeconds >= 0 : TIMEOUT_ERROR_MESSAGE;
        return new FluentWait<>(Browser.getInstance().getWrappedDriver())
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(POLLING_EVERY_MILLISECONDS))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public static String getAttribute(By locator, String attribute) {
        if (locator == null) {
            throw new IllegalArgumentException(String.format("Invalid locator: %s", LOCATOR_ERROR_MESSAGE));
        }
        if (attribute == null) {
            throw new IllegalArgumentException(String.format("Invalid attribute: %s", ATTRIBUTE_ERROR_MESSAGE));
        }
        waitForPageElementPresenceLocated(locator);
        WebDriver wrappedDriver = Browser.getInstance().getWrappedDriver();
        WebElement webElement = wrappedDriver.findElement(locator);
        return webElement.getAttribute(attribute).trim();
    }

    public static void waitForPageElementVisibilityLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        waitForPageElementVisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementVisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_ERROR_MESSAGE);
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForAllPageElementsVisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_ERROR_MESSAGE);
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void waitForPageElementInvisibilityLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        waitForPageElementInvisibilityLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementInvisibilityLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_ERROR_MESSAGE);
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForPageElementPresenceLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        waitForPageElementPresenceLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementPresenceLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_ERROR_MESSAGE);
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForAllElementsPresenceLocated(By locator) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        waitForAllElementsPresenceLocated(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForAllElementsPresenceLocated(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_ERROR_MESSAGE);
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static void waitForPageElementToBeClickable(By locator) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        waitForPageElementToBeClickable(locator, TIMEOUT_IN_SECONDS);
    }

    public static void waitForPageElementToBeClickable(By locator, int timeoutInSeconds) {
        Objects.requireNonNull(locator, LOCATOR_ERROR_MESSAGE);
        if (timeoutInSeconds < 0) {
            throw new IllegalArgumentException(TIMEOUT_ERROR_MESSAGE);
        }
        Wait<? extends WebDriver> wait = getCustomWait(timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean isElementVisible(By locator, int timeoutInSeconds) {
        try {
            waitForPageElementVisibilityLocated(locator, timeoutInSeconds);
            return true;
        } catch (TimeoutException e) {
            Log.info("No element found on current page.");
            return false;
        }
    }
}
