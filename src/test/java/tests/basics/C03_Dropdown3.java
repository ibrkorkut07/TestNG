package tests.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_Dropdown3 {
    WebDriver driver;
    WebElement dropdownboxElement;
    Select select;
    // https://www.amazon.com/ adresine gidin.
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        dropdownboxElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownboxElement);
    }
    //  Test 1: Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    @Test
    public void categorySizeTest() {
        Assert.assertEquals(select.getOptions().size(), 28);
    }

    @Test
    public void searchTest() {
    //  Test 2:
    //       1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");
    //       2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
    //       3. Bulunan sonuc sayisini yazdirin
        WebElement searchResultText = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(searchResultText.getText());
    //       4. Sonucun Java kelimesini icerdigini test edin
        String expWord = "Java";
        String actWord = searchResultText.getText();
        Assert.assertTrue(actWord.contains(expWord));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}