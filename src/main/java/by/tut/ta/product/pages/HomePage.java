package by.tut.ta.product.pages;

import by.tut.ta.framework.browser.Browser;
import by.tut.ta.framework.ui.components.Button;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    @Override
    public HomePage open() {
        Browser.getInstance().navigate(BASE_URL);
        return this;
    }

    public AfishaPage clickAfishaButton() {
        By afishaButtonLocator = By.xpath("(//ul[@class='b-topbar-i']//li)[5]/a");
        Button afishaButton = new Button(afishaButtonLocator);
        afishaButton.click();
        return new AfishaPage();
    }
}
