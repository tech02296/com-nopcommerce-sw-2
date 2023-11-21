package testsuite;
/*
 * click on the ‘Register’ link
 * Verify the text ‘Register’
 * * Select gender radio button
* Enter First name
* Enter Last name
* Select Day Month and Year
* Enter Email address
* Enter Password
* Enter Confirm password
* Click on REGISTER button
* Verify the text 'Your registration
completed’

 */


import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    Random random = new Random();
    int num = random.nextInt(800);

    //extending base class
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before

    public void setup(){
        openBrowser(baseUrl);
    }
@Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
    WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
    registerLink.click();

    WebElement message = driver.findElement(By.xpath("//a[text()='Register']"));
    Assert.assertEquals("Register", message.getText());

}

    @Test
    public void userSholdRegisterAccountSuccessfully() {



        WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerLink.click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Mehul" + num);
        driver.findElement(By.id("LastName")).sendKeys("Testing" + num);

        driver.findElement(By.name("DateOfBirthDay")).sendKeys("6");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("October");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1985");

        driver.findElement(By.id("Email")).sendKeys("chotaliya"+ num + "@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Smarttech");

        driver.findElement(By.id("Password")).sendKeys("tech3210");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("tech3210");
        driver.findElement(By.id("register-button")).click();

        WebElement actual = driver.findElement(By.xpath("//div[@class='result']"));

        Assert.assertEquals("Your registration completed", actual.getText());


    }
}



        







