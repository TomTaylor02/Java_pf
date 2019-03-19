package stqa.ft.golf;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


import static org.testng.Assert.fail;

public class GoogleHouseCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();

  }

  @Test
  public class AlertPopUp {

    public void main(String[] args) {
      WebDriver driver=new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.get("http://www.services.irctc.co.in/");
      driver.findElement(By.id("button")).click();
      Alert alert = driver.switchTo().alert();
      System.out.println(alert.getText());
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      alert.dismiss();
    }

  }


  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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

}
