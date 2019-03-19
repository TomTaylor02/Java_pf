package stqa.ft.golf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings {

    WebDriver driver;

    @BeforeTest
    public void startDriver() {
        driver = new FirefoxDriver();

    }
    @AfterTest
    public void stopDriver() {
        driver.quit();
    }

}