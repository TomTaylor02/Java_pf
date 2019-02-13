package stqa.ft.golf;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase8 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.budgetgolf.com/golf-gloves/#!|page|1|opp|30");
        List<WebElement> elements = driver.findElements(By.className("pr_list_thumb"));

        driver.findElement(By.xpath("//img[@alt='OnCourse All Weather Golf Glove']")).click();
        String productURL = "OnCourse All Weather Golf Glove";

        Select dropdown = new Select(driver.findElement(By.id("product_avail")));

        // If quantity is 1, then no test
        if( dropdown.getOptions().size() < 2 )
        {
            return;
        }

        // Input testing quantity (select from the drop down list)
        driver.findElement(By.xpath("//option[@value='2']")).click();

        // Click to add to the cart
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Quantity in popup window
        WebElement Q2 = driver.findElement(By.className("product_info_tbl")).findElement(By.className("p1")).findElement(By.className("inner"));
        String valQ2 = Q2.getText().replaceAll("[^0-9.]", "");
        //System.out.println(valQ2);
        driver.findElement(By.linkText("View Cart")).click();

        // Quantity in the cart
        WebElement Q3 = driver.findElement(By.className("product-price-text")).findElement(By.cssSelector("input[type='text']"));
        String valQ3 = Q3.getAttribute("value");
        //System.out.println(valQ3);

        // Clear cart
        driver.findElement(By.xpath("//body[@id='main_bg']/div/div/div/div[4]/div/div[2]/div/form/div/div/div/div[2]/div/div[4]/div[3]/a/span")).click();

        // Compare product quantity
        if(!valQ2.equals(valQ3))
        {
            System.out.println("Quantity is different: " + Q2 + " != " + Q3);
            System.out.println("URL: " + productURL);
        }
    }




    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            // fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}




