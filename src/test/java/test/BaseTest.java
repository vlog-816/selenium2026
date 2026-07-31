package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    public void initBrowser() {
        driver = new ChromeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) driver.quit();
    }

}
