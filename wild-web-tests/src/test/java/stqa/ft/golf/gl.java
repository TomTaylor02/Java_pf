package stqa.ft.golf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
 
public class gl {
    public WebDriver driver;
 
    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }
 
    @Test
    public void someSimpleTest() {
        driver.get("http://internetka.in.ua");
 
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
 
        driver.findElement(By.tagName("a")).click();
 
        String newWindow = (new WebDriverWait(driver, 10))
            .until(new ExpectedCondition<String>() {
                public String apply(WebDriver driver) {
                    Set<String> newWindowsSet = driver.getWindowHandles();
                    newWindowsSet.removeAll(oldWindowsSet);
                    return newWindowsSet.size() > 0 ? 
                                 newWindowsSet.iterator().next() : null;
                  }
                }
            );
 
        driver.switchTo().window(newWindow);
 
        System.out.println("New window title: " + driver.getTitle());
        driver.close();
 
        driver.switchTo().window(originalWindow);
        System.out.println("Old window title: " + driver.getTitle());
 
    }
 
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}