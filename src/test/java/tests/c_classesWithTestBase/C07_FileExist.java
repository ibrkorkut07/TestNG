package tests.c_classesWithTestBase;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExist {

    @Test
    public void test() {
        System.out.println(System.getProperty("user.home"));  // C:\Users\ibrko
        String filePath = System.getProperty("user.home") + "\\OneDrive\\Desktop\\images.jpg";
        System.out.println(filePath);
        System.out.println(Files.exists(Paths.get(filePath)));
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
        System.out.println(System.getProperty("user.dir"));
    }
}

// "C:\Users\ibrko\OneDrive\Desktop\SELENIUM WEBDRIVER\images.jpg"
// C:\Users\ibrko\OneDrive\Desktop\SELENIUM WEBDRIVER
// \images.jpg