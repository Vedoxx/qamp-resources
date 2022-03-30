package placelab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import placelab.utilities.WebDriverSetup;

public class LoginForgotPassword {
    public WebDriver driver;
    private String host = System.getProperty("host");
    private String forgotPassword = "Forgot your password?";
    private String passwordForgot="https://demo.placelab.com/password/forgot";
    @BeforeSuite
    public void initDriver() {

        driver = WebDriverSetup.getWebDriver("firefox");

    }
    @Test
    public void testLoginPage() {
        //Go to PlaceLab demo app
        driver.navigate().to(host);

        //Validate that user is redirected to the right page
        Assert.assertEquals(driver.getCurrentUrl(), host);
        Assert.assertEquals(driver.getTitle(), "PlaceLab");
        WebElement forgotPassword=driver.findElement(By.linkText("Forgot your password?"));
        forgotPassword.click();
        Assert.assertEquals(driver.getCurrentUrl(), passwordForgot);
    }
    @AfterSuite
    public void quitDriver() {
        driver.close();
    }

}
