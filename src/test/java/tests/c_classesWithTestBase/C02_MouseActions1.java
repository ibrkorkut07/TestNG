package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions1 extends TestBase {

    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // Cizili alan uzerinde sag click yapalim
    // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    // Tamam diyerek alert’i kapatalim
    // Elemental Selenium linkine tiklayalim
    // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String menuPageHandle = driver.getWindowHandle();
        // Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement linedBoxElement = driver.findElement(By.id("hot-spot"));
        actions.moveToElement(linedBoxElement).contextClick().perform();
        // Thread.sleep(3000);
        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actAlertText = driver.switchTo().alert().getText();
        // System.out.println(alertText);
        String expText = "You selected a context menu";
        Assert.assertEquals(actAlertText, expText);
        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // Thread.sleep(3000);
        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        // System.out.println(driver.getWindowHandles());
        Set<String> windowHandleList = driver.getWindowHandles();
        String seleniumPageHandle = "";
        for (String each: windowHandleList) {
            if (!each.equals(menuPageHandle)) {
                seleniumPageHandle=each;
            }
            driver.switchTo().window(seleniumPageHandle);
            String expSeleniumText = "Elemental Selenium";
            String actSeleniumText = driver.findElement(By.tagName("h1")).getText();
            Assert.assertEquals(actSeleniumText, expSeleniumText);
        }

    }
}
