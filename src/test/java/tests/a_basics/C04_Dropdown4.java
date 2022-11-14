package tests.a_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_Dropdown4 {

    WebDriver driver;
    Select options;
    //  1. http://zero.webappsecurity.com Adresine gidin
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com");
    }
    //  2. Sign in butonuna basin
    //  3. Login kutusuna “username” yazin
    //  4. Password kutusuna “password.” yazin
    //  5. Sign in tusuna basin
    @Test
    public void signinTest() {
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='submit']")).click();
    }
    //  6. Pay Bills sayfasina gidin
    //  7. “Purchase Foreign Currency” tusuna basin
    //  8. “Currency” drop down menusunden Eurozone’u secin
    //  9. “amount” kutusuna bir sayi girin
    //  10. “US Dollars” in secilmedigini test edin
    //  11. “Selected currency” butonunu secin
    //  12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //  13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
    @AfterClass
    public void tearDown() {
        // driver.quit();
    }
}
