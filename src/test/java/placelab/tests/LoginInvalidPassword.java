package placelab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import placelab.utilities.WebDriverSetup;

public class LoginInvalidPassword {
    public WebDriver driver;
    private String host = System.getProperty("host");
    private String username = System.getProperty("username");
    private String invalidPassword = "invalidPassword";
    private String credentialsError = "Invalid credentials!";
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
        WebElement enterUsername = driver.findElement(By.id("email"));
        enterUsername.sendKeys(username);
        WebElement enterPassword = driver.findElement(By.xpath("//*[@id='password']"));
        enterPassword.sendKeys(invalidPassword);
        //If there is a unique identifier it will be used instead this is just practise :)
        WebElement submitForm = driver.findElement(By.cssSelector("input[value$='Log in']"));
        submitForm.click();
        Assert.assertEquals(driver.getCurrentUrl(), host);
        WebElement error = driver.findElement(By.className("error-area"));
        if(error.getText().contains(credentialsError)){
            System.out.println("Error message:"+error.getText());
        }
    }
        @AfterSuite
        public void quitDriver() {
            driver.close();
        }
    }



