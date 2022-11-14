package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_MouseActions2 extends TestBase {
    // https://demoqa.com/droppable adresine gidelim
    // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    @Test
    public void test() {
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement dragmeElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drophereElement = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(dragmeElement, drophereElement).perform();
        WebElement droppedText = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        // System.out.println(droppedText.getText());
        Assert.assertEquals(droppedText.getText(), "Dropped!");
    }

}