package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    // extending base class

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToComputerPageSuccessfully() {


        //click on the ‘Computers’ Tab
        WebElement tabComputer = driver.findElement(By.partialLinkText("Computers"));
        tabComputer.click();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
        //actual tab
        String actualPageTitle = pageTitle.getText();
        //expected tab
        String expectedPageTitle = "Computers";
        //Verify the text ‘Computers’
        Assert.assertEquals("Incorrect tab display", expectedPageTitle, actualPageTitle);

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        // click on the ‘Electronics’ Tab
        WebElement tabElec = driver.findElement(By.partialLinkText("Electronics"));
        tabElec.click();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
        //actual value came from webelement by getText method
        String actualPageTitle = pageTitle.getText();
        //expected tab value
        String expectedPageTitle = "Electronics";
        //* Verify the text ‘Electronics’
        Assert.assertEquals("Incorrect tab display", expectedPageTitle, actualPageTitle);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //click on the ‘Apparel’ Tab
        WebElement tabApp = driver.findElement(By.partialLinkText("Apparel"));
        tabApp.click();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
        //actual value came from webelement by getText method
        String actualPageTitle = pageTitle.getText();
        //expected tab value
        String expectedPageTitle = "Apparel";
        // Verify the text ‘Apparel’
        Assert.assertEquals("Incorrect tab spelling", expectedPageTitle, actualPageTitle);

    }

    //click on the ‘Digital downloads’ Tab
    // Verify the text ‘Digital downloads’
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        WebElement digitalDown = driver.findElement(By.partialLinkText("Digital downloads"));
        digitalDown.click();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Digital downloads";
        Assert.assertEquals("incorrect Page Title", expectedPageTitle, actualPageTitle);

    }

    /*

     * click on the ‘Books’ Tab
     * Verify the text ‘Books’
     */
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        WebElement books = driver.findElement(By.partialLinkText("Books"));
        books.click();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Books";
        Assert.assertEquals("Incorrect Page Title", expectedPageTitle, actualPageTitle);
    }

    /*
    userShouldNavigateToJewelryPageSuccessfully
* click on the ‘Jewelry’ Tab
* Verify the text ‘Jewelry’
     */
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        WebElement jewelry = driver.findElement(By.partialLinkText("Jewelry"));
        jewelry.click();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Jewelry";
        Assert.assertEquals("Incorrect Page Title", expectedPageTitle, actualPageTitle);
    }

    /*
    userShouldNavigateToGiftCardsPageSuccessfully
* click on the ‘Gift Cards’ Tab
* Verify the text ‘Gift Cards’
     */
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        WebElement giftCard = driver.findElement(By.partialLinkText("Gift Cards"));
        giftCard.click();
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualPageTitle = pageTitle.getText();
        String expectedPageTitle = "Gift Cards";
        Assert.assertEquals("Incorrect Page Title", expectedPageTitle, actualPageTitle);
    }

    @Test
    public void verifyAllTabsAndPageTitleUsingForEach() {
        //array list for all tabs
        String allTabs[] = {"Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards"};
        //created For Each Loop
        for (String tab : allTabs) {
            System.out.println(tab);
            //Single WebElement created  for all Tabs
            WebElement tabEle = driver.findElement(By.partialLinkText(tab));
            //click on each tab
            tabEle.click();
            //WebElement and Xpath to get page Title
            WebElement pageTitle = driver.findElement(By.xpath("//div[@class='page-title']"));
            //Actual page tile from WebElement
            String actualPageTitle = pageTitle.getText();
            //Expected page tile from allTabs Array
            String expectedPageTitle = tab;
            //verify Actual Vs Expected
            Assert.assertEquals(tab + " Incorrect Page Title " ,expectedPageTitle,actualPageTitle);
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }




    }









        




