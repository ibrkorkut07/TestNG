package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_KeyboardActions2 extends TestBase {

    // https://html.com/tags/iframe/ sayfasina gidelim
    // video’yu gorecek kadar asagi inin
    // videoyu izlemek icin Play tusuna basin
    // videoyu calistirdiginizi test edin

    @Test
    public void test01() throws InterruptedException {

        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.ARROW_UP)
                .perform();

        // videoyu izlemek icin Play tusuna basin
        // video iframe icinde oldugundan, once iframe'e gecis yapmaliyiz
        WebElement iframeElement=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        // videoyu calistirdiginizi test edin
        WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Pause (k)']"));
        Assert.assertTrue(pauseButton.isEnabled());

        Thread.sleep(10000);
    }
}
