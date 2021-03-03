package tut.by.tests.ui;

import by.tut.ta.framework.browser.Browser;
import by.tut.ta.framework.listeners.TestListener;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseConfigurationTest {
    protected Browser browser;

    @BeforeClass(description = "Set Up")
    public void setUp() {
        browser = Browser.getInstance();
    }

    @AfterClass(description = "Tear Down")
    public void tearDown() {
        browser.stop();
    }
}
