package stqa.ft.golf;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase6 {
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
        driver.get("https://www.budgetgolf.com/golf-gloves/");

        List<WebElement> elements = driver.findElements(By.className("pr_list_thumb"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement item = elements.get(i);
            WebDriver driver1 = new FirefoxDriver();
            String productURL = item.getAttribute("href");

            driver1.get(productURL);
            // test
            Select dropdown = new Select(driver1.findElement(By.id("product_avail")));
            // If quantity is 1, then no test
            if (dropdown.getOptions().size() < 7) {
                driver1.quit();
            }
            //driver1.findElement(By.id("product_avail")).sendKeys("2");
            //driver1.findElement(By.xpath("//option[@value='2']")).click();
            //driver1.findElement(By.xpath("//button[@type='submit']")).click();
            //String Window1 = driver1.getWindowHandle();
            //Set<String> Windows = driver1.getWindowHandles();

            //driver1.findElement(By.linkText("View Cart")).click();
            driver1.quit();
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




   