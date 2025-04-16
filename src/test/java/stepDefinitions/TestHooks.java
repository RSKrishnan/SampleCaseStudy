package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utilities.BaseClass;

public class TestHooks {

    @BeforeAll
    public static void setUp() {
        BaseClass.initializeDriver();
    }

    @AfterAll
    public static void tearDown() {
        // Uncomment to close the browser after all tests
        // BaseClass.quitDriver();
    }
}
