package by.tut.ta.product.pages;

import by.tut.ta.framework.browser.Browser;
import by.tut.ta.framework.ui.components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static by.tut.ta.framework.ui.components.CommonPageElement.waitForAllElementsPresenceLocated;

public class AfishaPage extends BasePage {

    @Override
    public AfishaPage open() {
        Browser.getInstance().navigate("https://afisha.tut.by/");
        return this;
    }

    public AfishaPage clickOnlineCinemasButton() {
        By onlineCinemasButtonLocator = By.xpath("//ul[@class='main_menu']//a[@title='Онлайн-кинотеатры']");
        Button onlineCinemasButton = new Button(onlineCinemasButtonLocator);
        onlineCinemasButton.click();
        return this;
    }

    public AfishaPage clickSerialsButton() {
        By serialsButtonLocator = By.xpath("//a[@data-show='serial']");
        Button serialsButton = new Button(serialsButtonLocator);
        serialsButton.click();
        return this;
    }

    public AfishaPage clickAnimationButton() {
        By animationButtonLocator = By.xpath("//a[@data-show='animation']");
        Button animationButton = new Button(animationButtonLocator);
        animationButton.click();
        return this;
    }

    public AfishaPage selectFilmsGenre(String genre) {
        By genreButtonLocator = By.xpath("(//div[@id='tab-films']//button)[1]");
        By genreNameDynamicLocator = By.xpath(String.format
                ("(//ul[@class='dropdown-menu inner selectpicker'])[1]//span[contains(text(), '%s')]", genre));
        Button button = new Button(genreButtonLocator);
        button.click();
        button = new Button(genreNameDynamicLocator);
        button.click();
        return this;
    }

    public AfishaPage selectSerialsGenre(String genre) {
        By genreButtonLocator = By.xpath("(//div[@id='tab-tv-series']//button)[1]");
        By genreNameDynamicLocator = By.xpath(String.format
                ("(//ul[@class='dropdown-menu inner selectpicker'])[5]//span[contains(text(), '%s')]", genre));
        Button button = new Button(genreButtonLocator);
        button.click();
        button = new Button(genreNameDynamicLocator);
        button.click();
        return this;
    }

    public AfishaPage selectAnimationsGenre(String genre) {
        By genreButtonLocator = By.xpath("(//div[@id='tab-cartoons']//button)[1]");
        By genreNameDynamicLocator = By.xpath(String.format
                ("(//ul[@class='dropdown-menu inner selectpicker'])[9]//span[contains(text(), '%s')]", genre));
        Button button = new Button(genreButtonLocator);
        button.click();
        button = new Button(genreNameDynamicLocator);
        button.click();
        return this;
    }

    public List<WebElement> getAllResultsOnPage() {
        By searchResultProductsLocator = By.xpath("//li[@class='lists__li ']//div");
        waitForAllElementsPresenceLocated(searchResultProductsLocator);
        return Browser.getInstance().getWrappedDriver().findElements(searchResultProductsLocator);
    }
}
