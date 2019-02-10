package stqa.ft.golf;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.budgetgolf.com/golf-gloves/");
        //Thread.sleep(8000);
        List<WebElement> elements = driver.findElements(By.className("pr_list_thumb"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement item = elements.get(i);
            WebDriver driver1 = new FirefoxDriver();
            driver1.get(item.getAttribute("href"));
            // test
            driver1.findElement(By.id("product_avail")).sendKeys("2");
            driver1.findElement(By.xpath("//option[@value='2']")).click();
            driver1.findElement(By.xpath("//button[@type='submit']")).click();
            driver1.findElement(By.xpath("//body[@id='main_bg']/div[15]")).click();
            //прооверка на соответствие
            driver1.findElement(By.linkText("View Cart")).click();
            driver1.findElement(By.xpath("//body[@id='main_bg']/div/div/div/div[4]/div/div[2]/div/form/div/div/div/div[2]/div/div[4]/div[3]/a/span")).click();
            driver1.close();
        }

    }@AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
         //   fail(verificationErrorString);
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




   