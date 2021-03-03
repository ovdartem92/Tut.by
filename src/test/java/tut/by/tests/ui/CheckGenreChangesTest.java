package tut.by.tests.ui;

import by.tut.ta.product.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckGenreChangesTest extends BaseConfigurationTest {
    HomePage homePage = new HomePage();

    @Test(description = "Check the ability to search for films by genre in the online cinema")
    public void scenarioOne() {
        String genre = "Аниме";
        List<WebElement> moveResult = homePage
                .open()
                .clickAfishaButton()
                .clickOnlineCinemasButton()
                .selectFilmsGenre(genre)
                .getAllResultsOnPage();
        for (WebElement webElement : moveResult) {
            Assert.assertTrue(webElement.getText().contains(genre),
                    "The movie doesn't contains the desired genre: " + genre);
        }
    }

    @Test(description = "Check the ability to search for serials by genre in the online cinema")
    public void scenarioTwo() {
        String genre = "Ужасы";
        List<WebElement> moveResult = homePage
                .open()
                .clickAfishaButton()
                .clickOnlineCinemasButton()
                .clickSerialsButton()
                .selectSerialsGenre(genre)
                .getAllResultsOnPage();
        for (WebElement webElement : moveResult) {
            Assert.assertTrue(webElement.getText().contains(genre),
                    "The serial doesn't contains the desired genre: " + genre);
        }
    }

    @Test(description = "Check the ability to search for animations by genre in the online cinema")
    public void scenarioThree() {
        String genre = "Фантастика";
        List<WebElement> moveResult = homePage
                .open()
                .clickAfishaButton()
                .clickOnlineCinemasButton()
                .clickAnimationButton()
                .selectAnimationsGenre(genre)
                .getAllResultsOnPage();
        for (WebElement webElement : moveResult) {
            Assert.assertTrue(webElement.getText().contains(genre),
                    "The animations doesn't contains the desired genre: " + genre);
        }
    }
}
