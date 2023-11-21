package testsuite;
/*
Verify the text ‘Welcome, Please Sign
In!’
*/


import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// extending base test class

public class LoginTest extends BaseTest{

    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);

    }

    @Test

    public void VerifyUserShouldNavigateToLoginPageSuccessfully(){
        // find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedText = "Welcome, Please Sign In!";
        //find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText();
        //verify expected and actual result
        Assert.assertEquals(expectedText,actualText);
    }
    @Test

    public void VerifyuserShouldLoginSuccessfullyWithValidCredentials(){
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // find the email field and type the email address

        WebElement emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys("prime123@gmail.com");

        // find the password field and type the password

        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("Prime123");

        // find the login button and click

        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        WebElement logoutLink = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String expected = "Log out";
        Assert.assertEquals(expected, logoutLink.getText());



    }
    @Test

    public void verifyTheErrorMessage() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // find the email field and type the email field

        WebElement emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys("mehul123@gmail.com");

        // find the password field and type the password

        driver.findElement(By.name("Password")).sendKeys("mehul123");

        // find the login button and click

        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        // find the errorMessage element

        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Test case pass", expectedErrorMessage, actualErrorMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();


    }


}
