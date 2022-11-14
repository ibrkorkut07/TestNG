package tests.b_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C07_Iframe {

    // https://the-internet.herokuapp.com/iframe adresine gidin.
    // Bir metod olusturun: iframeTest
    // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    // Text Box’a “Merhaba Dunya!” yazin.
    // TextBox’in altinda bulunan “Elemental Selenium” link textinin gorunur oldugunu
    // dogrulayin ve konsolda yazdirin.
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){

        WebElement frametext = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(frametext.isEnabled());
        System.out.println(frametext.getText());
        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frameElement);
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Hello");
        driver.switchTo().defaultContent();
        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(seleniumText.isDisplayed());
        System.out.println(seleniumText.getText());
    }
}
