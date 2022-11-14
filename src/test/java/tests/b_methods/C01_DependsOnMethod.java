package tests.b_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethod {
    WebDriver driver;
    //  https://www.amazon.com adresine gidin.
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    //  1. Test : Amazon ana sayfaya gittiginizi test edin
    @Test
    public void pageTest() {
        String expUrl = "https://www.amazon.com/";
        String actUrl = driver.getCurrentUrl();
        Assert.assertEquals(actUrl, expUrl);
    }
    //  2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
    //  arama yapin ve aramanizin gerceklestigini Test edin
    @Test (dependsOnMethods = "pageTest")
    public void searchTest(){
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);
        String resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expWord = "Nutella";
        Assert.assertTrue(resultText.contains(expWord));
    }
    //  3. Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    //  $16.83 oldugunu test edin
    @Test (dependsOnMethods = "searchTest")
    public void priceTest() {
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-wide-3-2-aspect'])[1]")).click();

    }

    @AfterClass
    public void tearDown(){
        // driver.quit();
    }
}
