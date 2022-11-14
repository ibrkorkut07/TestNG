package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_KeyboardActions1 extends TestBase {
    // https://www.amazon.com/ sayfasina gidelim
    // Arama kutusuna actions method’larine kullanarak
    // samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    // aramanin gerceklestigini test edin

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(5000);
    }
}