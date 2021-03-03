package tut.by.tests.ui;

import by.tut.ta.framework.browser.Browser;
import by.tut.ta.framework.listeners.TestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseConfigurationTest {
    protected Browser browser;

    @BeforeTest(description = "Set Up")
    public void setUp() {
        browser = Browser.getInstance();
    }

    @AfterTest(description = "Tear Down")
    public void tearDown() {
        browser.stop();
    }
}
