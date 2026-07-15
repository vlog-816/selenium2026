package model.test_global_component;

import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FooterTest {

    @Test
    public void testFooterHomepage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        try {

            HomePage homePage = new HomePage(driver);

            String headerText = homePage.footerComp().informationColumnComp().headerElem().getText();
            System.out.println(headerText);
            homePage.footerComp().informationColumnComp().linksElem().forEach(link -> {
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    @Test
    public void testFooterCategoryPage() {
    }

    @Test
    public void testFooterRegisterPage() {
    }

    @Test
    public void testFooterLoginPage() {
    }

}
