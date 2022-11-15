package tests.c_classesWithTestBase;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C11_Faker extends TestBase {

    // 1. https://facebook.com" Adresine gidin
    // 2. “create new account” butonuna basin
    // 3. “firstName” giris kutusuna bir isim yazin
    // 4. “surname” giris kutusuna bir soyisim yazin
    // 5. “email” giris kutusuna bir email yazin
    // 6. “email” onay kutusuna emaili tekrar yazin
    // 7. Bir sifre girin
    // 8. Tarih icin gun secin
    // 9. Tarih icin ay secin
    // 10.Tarih icin yil secin
    // 11.Cinsiyeti secin
    // 12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    // 13.Sayfayi kapatin

    @Test
    public void test() {
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        driver.findElement(By.xpath("//a[@ajaxify='/reg/spotlight/']")).click();
        WebElement firstNameBoxElement = driver.findElement(By.xpath("//input[@placeholder='First name']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        WebElement monthDropdownElement = driver.findElement(By.xpath("//select[@id='month']"));
        Select select = new Select(monthDropdownElement);
        // String firstName = faker.
        actions.click(firstNameBoxElement).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(password).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                sendKeys("Jan").sendKeys("15").sendKeys("1972").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();
        driver.findElement(By.xpath("//button[@name='websubmit']"));
        WebElement femaleBox = driver.findElement(By.xpath("//label[@for='u_3_4_yn']"));
        WebElement maleBox = driver.findElement(By.xpath("//label[@for='u_3_5_E5']"));
        WebElement customBox = driver.findElement(By.xpath("//label[@for='u_3_6_mb']"));
        Assert.assertTrue(monthDropdownElement.isSelected());
        Assert.assertFalse(femaleBox.isSelected());
        Assert.assertFalse(customBox.isSelected());
        driver.quit();

    }









}
