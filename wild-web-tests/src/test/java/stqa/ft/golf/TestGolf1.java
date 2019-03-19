package stqa.ft.golf;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;


public class TestGolf1 {
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
    driver.get("https://www.taylormadegolf.com/");
    //driver.findElement(By.xpath("//button[contains(text()='No thanks')]")).click();

    driver.findElement(By.xpath("//a href='taylormade-accessories-gloves'/descendant::text()='Gloves'")).click();

    driver.findElement(By.xpath("//div[@class='product-image']/descendant::img")).click();

    driver.findElement(By.id("va-tm_enrich_hand-hand_right")).click();
    driver.findElement(By.id("va-tm_enrich_nonComfilSize")).click();
    new Select(driver.findElement(By.id("va-tm_enrich_nonComfilSize"))).selectByVisibleText("Medium");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Size'])[1]/following::option[3]")).click();
    driver.findElement(By.linkText("▲")).click();
    driver.findElement(By.id("add-to-cart")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Items:'])[1]/following::span[1]")).click();
    driver.findElement(By.linkText("▲")).click();
    driver.findElement(By.name("dwfrm_cart_shipments_i0_items_i0_deleteProduct")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Right'])[2]/following::span[1]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
