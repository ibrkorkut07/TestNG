package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;

public class C09_FileUpload extends TestBase {

    // https://the-internet.herokuapp.com/upload adresine gidelim
    // chooseFile butonuna basalim
    // Yuklemek istediginiz dosyayi secelim
    // Upload butonuna basalim
    // “File Uploaded!” textinin goruntulendigini test edelim

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileElement = driver.findElement(By.id("file-upload"));
        String filepath = System.getProperty("user.home") + "\\OneDrive\\Desktop\\images.jpg";
        chooseFileElement.sendKeys(filepath);
        driver.findElement(By.id("file-submit")).submit();
        String actUploadedText = driver.findElement(By.tagName("h3")).getText();
        String exptext = "File Uploaded!";
        Assert.assertEquals(actUploadedText, exptext);


    }
}

//  C:\Users\ibrko\OneDrive\Desktop\images.jpg