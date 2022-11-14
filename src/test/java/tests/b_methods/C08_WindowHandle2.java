package tests.b_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C08_WindowHandle2 {
    // Amazon anasayfa adresine gidin.
    // Sayfa’nin window handle degerini String bir degiskene atayin
    // Sayfa title’nin “amazon” icerdigini test edin

    // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    // Sayfa title’nin “Walmart” icerdigini test edin
    // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
    }
    @Test
    public void test(){
        // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");
        // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandleString = driver.getWindowHandle();
        // Sayfa title’nin “amazon” icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.techproeducation.com");
        String techproHandleString = driver.getWindowHandle();
        // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com/");
        // Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandleString);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
