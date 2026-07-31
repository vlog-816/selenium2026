package test.global.footer;

import model.components.global.footer.*;
import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.global.FooterTestFlow;

public class FooterTest extends BaseTest {

    @Test
    public void testFooterCategoryPage() {
        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatComponent();
    }

    @Test
    public void testFooterHomePage() {

        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }
}
