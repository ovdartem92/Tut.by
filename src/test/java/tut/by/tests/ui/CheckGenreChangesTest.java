package tut.by.tests.ui;

import by.tut.ta.product.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckGenreChangesTest extends BaseConfigurationTest {
    HomePage homePage = new HomePage();

    @Test(description = "")
    public void scenarioOne() {
        String genre = "Аниме";
        List<WebElement> moveResult = homePage
                .open()
                .clickAfishaButton()
                .clickOnlineCinemasButton()
                .selectFilmsGenre(genre)
                .getAllMovieResults();
        for (WebElement webElement : moveResult) {
            Assert.assertTrue(webElement.getText().contains(genre),
                    "The movie doesn't contains the desired genre: " + genre);
        }
    }

    @Test(description = " ")
    public void scenarioTwo() {
        String genre = "Ужасы";
        List<WebElement> moveResult = homePage
                .open()
                .clickAfishaButton()
                .clickOnlineCinemasButton()
                .clickSerialsButton()
                .selectSerialsGenre(genre)
                .getAllMovieResults();
        for (WebElement webElement : moveResult) {
            Assert.assertTrue(webElement.getText().contains(genre),
                    "The serial doesn't contains the desired genre: " + genre);
        }
    }

    @Test(description = " ")
    public void scenarioThree() {
        String genre = "Ужасы";
        List<WebElement> moveResult = homePage
                .open()
                .clickAfishaButton()
                .clickOnlineCinemasButton()
                .clickSerialsButton()
                .selectSerialsGenre(genre)
                .getAllMovieResults();
        for (WebElement webElement : moveResult) {
            Assert.assertTrue(webElement.getText().contains(genre),
                    "The serial doesn't contains the desired genre: " + genre);
        }
    }
}
