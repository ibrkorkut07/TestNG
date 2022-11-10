package tests.methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C05_Alerts {

    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // Bir metod olusturun: acceptAlert
    // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    // “You successfully clicked an alert” oldugunu test edin
    // Bir metod olusturun: dismissAlert
    // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    // “successfuly” icermedigini test edin
    // Bir metod olusturun: sendKeysAlert
    // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    // tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    // “You successfully clicked an alert” oldugunu test edin

    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String actSuccessAlertText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expSuccessText = "You successfully clicked an alert";
        System.out.println(actSuccessAlertText);
        Assert.assertEquals(actSuccessAlertText, expSuccessText);
        //  softAssert.assertEquals(actSuccessAlertText, expSuccessText);
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actDismissText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expDismissText = "successfully";     // You clicked: Cancel
        Assert.assertTrue(!actDismissText.contains(expDismissText));
        //  softAssert.assertTrue(!actDismissText.contains(expDismissText));
        //  softAssert.assertAll();
    }
    // Bir metod olusturun: dismissAlert
    // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    // “successfuly” icermedigini test edin

    @Test
    public void dismissAlert(){

    }
    // Bir metod olusturun: sendKeysAlert
    // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    // tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("ibr");
        driver.switchTo().alert().accept();
        String actSendNameAlertText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expWord = "ibr";     // You clicked: Cancel
        Assert.assertTrue(actSendNameAlertText.contains(expWord));
    }

    @AfterClass
    public void tearDown(){
        // driver.quit();
    }
}
