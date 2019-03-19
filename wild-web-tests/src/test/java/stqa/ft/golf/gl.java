package stqa.ft.golf;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class gl {
    public WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.taylormadegolf.com/");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.dismiss();
        driver.findElement(By.xpath("//input[contains(text()='email']")).click();
        //driver.findElement(By.xpath("//input[contains(text()='email']")).sendKeys("test77@gmail.com");

        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='You have been entered into our sweepstakes and will start receiving emails from TaylorMade Golf.'])[1]/following::button[1]")).click();

        //driver.findElement(By.xpath("//button[contains(text()='No thanks')]")).click();
        //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Golf Bags'])[1]/following::span[1]")).click();
        /*
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Go'])[1]/following::img[2]")).click();
        driver.findElement(By.id("va-tm_enrich_hand-hand_right")).click();
        driver.findElement(By.id("va-tm_enrich_nonComfilSize")).click();
        new Select(driver.findElement(By.id("va-tm_enrich_nonComfilSize"))).selectByVisibleText("Medium");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Size'])[1]/following::option[3]")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Back'])[1]/following::div[2]")).click();
        driver.findElement(By.linkText("View Cart")).click();
        driver.findElement(By.linkText("▲")).click();
        driver.findElement(By.name("dwfrm_cart_shipments_i0_items_i0_deleteProduct")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Right'])[2]/following::span[1]")).click();

    }
 */
    }
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}