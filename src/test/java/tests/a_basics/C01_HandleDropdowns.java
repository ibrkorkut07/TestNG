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

public class C01_HandleDropdowns {

    WebDriver driver;
    @Test
    public void dropdownTest() {
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> optionList = select.getOptions();

        for (WebElement each: optionList) {
            System.out.println(each.getText());
        }
    }

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}