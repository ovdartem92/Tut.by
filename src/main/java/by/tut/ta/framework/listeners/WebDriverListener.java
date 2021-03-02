package by.tut.ta.framework.listeners;

import by.tut.ta.framework.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverListener implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        Log.debug("Before alert acceptance");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        Log.debug(String.format("WebDriver navigated to %s", s));
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Log.debug(String.format("Before finding  web element with locator %s", by));
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        Log.debug(String.format("Before click on web element %s", webElement));
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        if (charSequences != null) {
            StringBuilder sb = new StringBuilder();
            for (CharSequence charSequence : charSequences) {
                sb.append(charSequence);
                sb.append(" ");
            }
            Log.debug(String.format("Before change of value of %s using %s", webElement, sb));
        }
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
//unused method
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
//unused method
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
//unused method
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
//unused method
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
//unused method
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
//unused method
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
//unused method
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
//unused method
    }
}
