package tests.c_classesWithTestBase;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.Driver;
import java.util.Set;

public class C12_CookiesAutomation extends TestBase {
    // 1. Amazon anasayfaya gidin
    // 2. tum cookie’leri listeleyin
    // 3. Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    // 4. ismi i18n prefs olan cookie degerinin USD oldugunu test edin
    // 5. ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    // 6. eklediginiz cookie’nin sayfaya eklendigini test edin
    // 7. ismi skin olan cookie’yi silin ve silindigini test edin
    // 8. tum cookie’leri silin ve silindigini test edin

    @Test
    public void test() {
        driver.get("https://www.amazon.com/");
        Integer cookieNumber = driver.manage().getCookies().size();
        Assert.assertTrue(cookieNumber > 5);
        String expCookieName = "USD";
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals(expCookieName));
        Cookie myCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(myCookie);
        Assert.assertTrue(driver.manage().getCookies().contains(myCookie));
        Set<Cookie> cookieList = driver.manage().getCookies();
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieList.contains("skin"));
        driver.manage().deleteAllCookies();
        System.out.println("Cookie sayisi: " + driver.manage().getCookies().size());
    }
}

        // Assert.assertTrue(driver.manage().getCookies().contains("en sevdigim cookie"));

