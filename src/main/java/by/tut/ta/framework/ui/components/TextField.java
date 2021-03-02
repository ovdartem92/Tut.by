package by.tut.ta.framework.ui.components;

import by.tut.ta.framework.browser.Browser;
import org.openqa.selenium.By;

import java.util.Objects;

public class TextField extends CommonPageElement{
    public TextField(By locator) {
        Objects.requireNonNull(locator, "Locator can not be null");
        this.locator = locator;
    }

    public void clear() {
        waitForPageElementVisibilityLocated(locator);
        Browser.getInstance().clear(locator);
    }

    public void type(CharSequence... textForType) {
        Objects.requireNonNull(textForType, "Text can not be null");
        waitForPageElementPresenceLocated(locator);
        Browser.getInstance().sendKeys(locator, textForType);
    }

    public String getText() {
        return CommonPageElement.getAttribute(locator, "value");
    }
}
