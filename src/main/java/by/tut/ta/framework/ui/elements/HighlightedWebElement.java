package by.tut.ta.framework.ui.elements;

import org.openqa.selenium.*;

import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

public class HighlightedWebElement implements AbstractWebElementDecorator {
    private final WebDriver driver;
    private final WebElement element;
    private final String backgroundColor;

    public HighlightedWebElement(WebDriver driver, WebElement element) {
        Objects.requireNonNull(driver, "Driver cannot be null.");
        Objects.requireNonNull(element, "Element cannot be null.");
        this.driver = driver;
        this.element = element;
        backgroundColor = "#FFBB00";
    }

    private void highlight(final String color) {
        assert color != null : "Color cannot be null";
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(format("arguments[0].style.backgroundColor = '%s'", color), element);
    }

    @Override
    public void click() {
        highlight(backgroundColor);
        element.click();
    }

    @Override
    public void submit() {
        highlight(backgroundColor);
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        Objects.requireNonNull(charSequences, "Char sequences cannot be null.");
        highlight(backgroundColor);
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        highlight(backgroundColor);
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String attribute) {
        Objects.requireNonNull(attribute, "Attribute cannot be null.");
        highlight(backgroundColor);
        return element.getAttribute(attribute);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        highlight(backgroundColor);
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        return element.findElements(locator);
    }

    @Override
    public WebElement findElement(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        return element.findElement(locator);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String value) {
        Objects.requireNonNull(value, "Value cannot be null.");
        return element.getAttribute(value);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) {
        return element.getScreenshotAs(outputType);
    }
}
