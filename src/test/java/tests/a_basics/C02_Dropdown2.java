package tests.a_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown2 {

    WebDriver driver;
    Select select;
    WebElement dropdownElement;
    //  https://the-internet.herokuapp.com/dropdown adresine gidin.
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        select = new Select(dropdownElement);
    }

    //  Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    @Test
    public void indexTest() {
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
    }
    //  Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    @Test
    public void valueTest() {
        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());
    }
    //  Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    @Test
    public void visibilityTest() {
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
    }
    //  Tüm dropdown değerleri(value) yazdırın
    @Test
    public void dropdownListTest() {
        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList) {
            System.out.println(each.getText());
        }

    }
    //  Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True, degilse False yazdırın
    @Test
    public void dropdownSizeTest() {

        List<WebElement> optionList = select.getOptions();
        int size = optionList.size();
        System.out.println(size);
        if (size==4) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
