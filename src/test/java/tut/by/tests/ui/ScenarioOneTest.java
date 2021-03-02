package tut.by.tests.ui;

import by.tut.ta.product.pages.HomePage;
import org.testng.annotations.Test;

public class ScenarioOneTest extends BaseConfigurationTest {
    HomePage homePage = new HomePage();

    @Test
    public void scenarioOne() {
        homePage
                .open()
                .clickToAfishButton()
                .clickToOnlineCinemas();
    }
}
