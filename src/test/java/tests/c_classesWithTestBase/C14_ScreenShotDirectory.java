package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C14_ScreenShotDirectory extends TestBase {
    // amazon'a gidin
    // 3 farkli test mesthodu ile java, nutella ve elma aratip
    // sonuc sayfasinin screenshot'i kaydedin

    WebElement searchBox;

    @Test
    public void javaTest() throws IOException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);
        fullPageScreenShot();
    }

    @Test
    public void nutellaTest() throws IOException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        fullPageScreenShot();
    }

    @Test
    public void elmaTest() throws IOException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("elma" + Keys.ENTER);
        fullPageScreenShot();
    }
}
