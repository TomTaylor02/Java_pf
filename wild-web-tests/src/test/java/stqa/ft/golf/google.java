package stqa.ft.golf;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class google {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\murga\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testGoogle() {
        driver.get("http://www.google.ru/");
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        List<WebElement> urls = driver.findElements(By.tagName("h3"));
        for (WebElement url : urls) {
            if (url.getAttribute("textContent").contains("Хаб")) {
                driver.navigate().to(
                        url.findElement(By.tagName("a")).getAttribute("href"));
                break;
            }
        }
        String getUrlOpenPage = (String) ((JavascriptExecutor)driver).executeScript("return window.document.location.toString();");
        //assertTrue(getUrlOpenPage.contains("habrhabr.ru"));
        assertTrue(getUrlOpenPage.contains("google.ru"));
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tearDoun(){
        driver.quit();
    }
}

