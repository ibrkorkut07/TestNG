package tests.b_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C06_BasicAuthentication {
    // https://the internet.herokuapp.com/basic_auth sayfasina gidin
    // asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    // Html komutu :
    // https://username:password@URL
    // Username : admin
    // password : admin
    // Basarili sekilde sayfaya girildigini dogrulayin
    // driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
    @Test
    public void test(){
        WebElement successTextElement = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(successTextElement.isDisplayed());
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
