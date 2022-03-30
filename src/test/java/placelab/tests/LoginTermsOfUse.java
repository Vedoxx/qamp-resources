package placelab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import placelab.utilities.WebDriverSetup;


public class LoginTermsOfUse {

    private String TermsOfUse = "https://demo.placelab.com/terms_of_service";
    public WebDriver driver;
    private String host = System.getProperty("host");
    @BeforeSuite
    public void initDriver() {

        driver = WebDriverSetup.getWebDriver("firefox");
    }
    @Test
    public void testLoginPage() throws InterruptedException {
        //Go to PlaceLab demo app
        driver.navigate().to(host);

        //Validate that user is redirected to the right page
        Assert.assertEquals(driver.getCurrentUrl(), host);
        Assert.assertEquals(driver.getTitle(), "PlaceLab");
        WebElement termsOfUse = driver.findElement(By.linkText("Terms of Use"));
        termsOfUse.click();
        Assert.assertEquals(driver.getCurrentUrl(), TermsOfUse);
    }
    @AfterSuite
    public void quitDriver() {
        driver.close();
    }

}
