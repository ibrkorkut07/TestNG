package tests.c_classesWithTestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C10_ExplicitlyWait extends TestBase {

    //  Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.
    //  https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //  Remove butonuna basin.
    //  “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //  Add buttonuna basin
    //  It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElemnti=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElemnti.isDisplayed());
        Thread.sleep(3000);
        // Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));

        Assert.assertTrue(itsBackElementi.isDisplayed());

        Thread.sleep(3000);
    }

    @Test
    public void explicitlyWaitTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // explicitly wait kullanabilmek icin once wait objesi olusturmaliyiz
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        /*
        WebElement itsGoneElemnti=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneElemnti));

        her ne kadar kodun anlasilabilir olmasi icin once locate edelim sonra bekleyelim yaklasimi daha guzel gorunse de
        web element zaten gorunur olmadigindan locate etmemiz de mumkun olmayacaktir
        bu durumda locate ve bekleme islemini beraber yapmak gerekir
         */

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        WebElement itsGoneElemnti=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElemnti.isDisplayed());
        Thread.sleep(3000);
        // Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // It’s back mesajinin gorundugunu test edin

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));

        WebElement itsBackElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));

        Assert.assertTrue(itsBackElementi.isDisplayed());


    }
}