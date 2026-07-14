package model.test_global_component;

import model.components.global.body.ProductItemComponent;
import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FeatureProductTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        testFeatureProductHomePage(driver);

        driver.quit();
    }

    private static void testFeatureProductHomePage(WebDriver driver) {

        driver.get("https://demowebshop.tricentis.com/");

        HomePage homePage = new HomePage(driver);
        List<ProductItemComponent> productItemComps =  homePage.productGridComp().productItemComps();
        productItemComps.forEach(productItemComp -> {
            System.out.println(productItemComp.productTitleElem().getText());
        });

    }
}
