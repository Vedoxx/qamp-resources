package placelab.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import placelab.utilities.WebDriverSetup;

public class LoginTest {
    public WebDriver driver;
    private String host = System.getProperty("host");
    private String username=System.getProperty("username");
    private String password=System.getProperty("password");
    private String homePageUrl=System.getProperty("homePage");
    private String user="Vedad Karalić";
    private String userRole = "Group Admin";
    //Specify the driver and browser that will be used for this scenario

    @BeforeSuite
    public void initDriver() {

        driver = WebDriverSetup.getWebDriver("firefox");
    }

    //Actual test case implementation

    @Test
    public void testLoginPage() {

        //Go to PlaceLab demo app
        driver.navigate().to(host);

        //Validate that user is redirected to the right page
        Assert.assertEquals(driver.getCurrentUrl(), host);
        Assert.assertEquals(driver.getTitle(), "PlaceLab");

        WebElement logo=driver.findElement(By.xpath("//img[@src='/assets/logo"+ "-526ea19604d26801aca90fe441f7df4775a24a5d74ae273dbc4af85f42241259.png']"));
        boolean logoPresent=logo.isDisplayed();
        Assert.assertTrue(logoPresent);
        System.out.println(logo.getLocation());
        WebElement enterUsername=driver.findElement(By.cssSelector("input[placeholder$='Email']"));
        enterUsername.sendKeys(username);
        WebElement enterPassword=driver.findElement(By.name("password"));
        enterPassword.sendKeys(password);
        WebElement submitForm=driver.findElement(By.cssSelector("input[value$='Log in']"));
        submitForm.click();
        Assert.assertEquals(driver.getCurrentUrl(),homePageUrl);
        try {
        WebElement userName = driver.findElement(By.id("user-name"));
        assert (userName.getText().contains(user));
        } catch (RuntimeException e) {
        e.printStackTrace();
        throw new RuntimeException("Expected user is not logged in!");
    }
        WebElement userRole=driver.findElement(By.id("user-role"));
        Assert.assertEquals(userRole.getText(),"Group Admin");
    }
    //Clean up - close the browser

    @AfterSuite
    public void quitDriver() {
        driver.close();
    }
}