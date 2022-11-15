package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
    }

    @AfterClass
    public void teardown() {
        // driver.quit();
    }

    public void fullPageScreenShot () throws IOException {
        String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File fullPage = new File("target/screenShot/fullPage" + date + ".jpg");
        File temporaryPagePhoto = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temporaryPagePhoto, fullPage);
    }

    public void webElementScreenShot () throws IOException {
        String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File webElementPhoto = new File("target/screenShot/webelement" + date + ".jpg");
        File tempWebElementPhoto = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tempWebElementPhoto, webElementPhoto);
    }
}
