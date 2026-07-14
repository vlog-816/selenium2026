package model.test_global_component;

import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            testFooterHomepage(driver);
            testFooterCategoryPage(driver);
            testFooterResgisterPage(driver);
            testFooterLoginPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    private static void testFooterHomepage(WebDriver driver) {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage(driver);

        String headerText = homePage.footerComp().informationColumnComp().headerElem().getText();
        System.out.println(headerText);
        homePage.footerComp().informationColumnComp().linksElem().forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }

    private static void testFooterCategoryPage(WebDriver driver) {
    }

    private static void testFooterResgisterPage(WebDriver driver) {
    }

    private static void testFooterLoginPage(WebDriver driver) {
    }

}
