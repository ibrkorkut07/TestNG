package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions3 extends TestBase {
    // https://www.amazon.com/ adresine gidelim
    // Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
    // mouse’u bu menunun ustune getirelim
    // “Create a list” butonuna basalim
    // Acilan sayfada “Your Lists” yazisi oldugunu test edelim
    @Test
    public void test() {
        driver.get("https://www.amazon.com/");
        WebElement listsElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(listsElement).perform();
        WebElement createlistElement = driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(createlistElement).perform();
        WebElement yourlistElement = driver.findElement(By.xpath("//div[@role='heading']"));
        String expText = "Your Lists";
        Assert.assertEquals(yourlistElement.getText(), expText );

    }
}
