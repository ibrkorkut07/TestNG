package tests.b_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C04_SoftAssertion3 {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    // 1. “https://hepsiburada.com/” Adresine gidin
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hepsiburada.com/");
    }

    // 2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    @Test
    public void Test(){
        String expTitle = "En Büyük";
        String actTitle = driver.getTitle();
        softAssert.assertTrue(actTitle.contains(expTitle), "Title does not contain the expected phrase");
        // 3. search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("araba" + Keys.ENTER);
        // 4. bulunan sonuc sayisini yazdirin
        String searchResultText = driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']")).getText();
        System.out.println(searchResultText);
        // 5. sonuc yazisinin "araba" icerdigini dogrulayin
        String expText = "araba";
        softAssert.assertTrue(searchResultText.contains(expText), "SearchresultText does not contain the word araba");
        // 6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        String otoWord = "oto";
        softAssert.assertFalse(searchResultText.contains(otoWord), "SearchresultText contains the word oto");
        softAssert.assertAll();
        System.out.println("hata varsa bu satir calismaz");
    }
}
