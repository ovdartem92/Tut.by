package tut.by.tests.ui;

import by.tut.ta.framework.browser.Browser;
import by.tut.ta.framework.listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseConfigurationTest {
    protected Browser browser;

    @BeforeMethod(description = "Set Up")
    public void setUp() {
        browser = Browser.getInstance();
    }

    @AfterMethod(description = "Tear Down")
    public void tearDown() {
        browser.stop();
    }
}
