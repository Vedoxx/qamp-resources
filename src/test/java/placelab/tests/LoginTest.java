package placelab.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;
    private String host = System.getProperty("host");

    //Specify the driver and browser that will be used for this scenario

    @BeforeSuite
    public void initDriver() {

    }

    //Actual test case implementation

    @Test
    public void testLoginPage() {


    }

    //Clean up - close the browser

    @AfterSuite
    public void quitDriver() {

    }
}