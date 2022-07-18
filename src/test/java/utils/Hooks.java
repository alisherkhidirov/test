package utils;

import org.junit.After;
import org.junit.Before;

public class Hooks {


    @Before
    public void setUp() {
        WebDriverUtils.getDriver().get(ConfigUtils.getProperty("url"));
    }

    @After
    public void tearDown() {
        WebDriverUtils.killDriver();
    }
}
