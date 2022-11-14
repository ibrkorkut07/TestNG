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
import java.util.Set;

public class C08_WindowHandle3 {
    // https://the-internet.herokuapp.com/windows adresine gidin.
    // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // Click Here butonuna basın.
    // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // Sayfadaki textin “New Window” olduğunu doğrulayın.
    // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
    }

    @Test
    public void test() throws InterruptedException {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement heroOpeningPageTextEl = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(heroOpeningPageTextEl.getText(), "Opening a new window");
        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(), "The Internet");
        // Click Here butonuna basın.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String newWindowHandle = driver.getWindowHandle();
        Set<String> windowHandlesSet = driver.getWindowHandles();
        String theInternetWindowHandle = "";
        for (String each: windowHandlesSet) {
            if (!each.equals(newWindowHandle)) {
                theInternetWindowHandle = each;
            }
        }
        driver.switchTo().window(theInternetWindowHandle);
        Assert.assertEquals(driver.getTitle(), "New Window");
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(newWindowHandle);

//        driver.switchTo().window(theInternetWindowHandle);
        Assert.assertEquals(driver.getTitle(), "The Internet");}
        @AfterClass
        public void teardown() {
            driver.quit();
        }
    }