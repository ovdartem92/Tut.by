package by.tut.ta.product.pages;

import by.tut.ta.framework.browser.Browser;
import by.tut.ta.framework.ui.components.Button;
import org.openqa.selenium.By;

public class AfishaPage extends BasePage {
    @Override
    public AfishaPage open() {
        Browser.getInstance().navigate("https://afisha.tut.by/");
        return this;
    }

    public AfishaPage clickToOnlineCinemas() {
        By onlineCinemasButtonLocator = By.xpath("(//ul[@class='main_menu']//li)[12]/a");
        Button onlineCinemasButton = new Button(onlineCinemasButtonLocator);
        onlineCinemasButton.click();
        return new AfishaPage();
    }
}
