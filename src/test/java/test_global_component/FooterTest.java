package test_global_component;

import model.components.global.footer.*;
import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;

public class FooterTest {

    @Test
    public void testFooterHomepage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        try {
            HomePage homePage = new HomePage(driver);

            InformationColumnComponent informationColumnComp = homePage.footerComp().informationColumnComp();
            CustomerServiceColumnComponent customerServiceColumnComp = homePage.footerComp().customerServiceColumnComp();
            MyAccountColumnComponent myAccountColumnComp = homePage.footerComp().myAccountColumnComp();
            FollowUsColumnComponent followUsColumnComp = homePage.footerComp().followUsColumnComp();

            testFooterColumn(informationColumnComp);
            testFooterColumn(customerServiceColumnComp);
            testFooterColumn(myAccountColumnComp);
            testFooterColumn(followUsColumnComp);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    @Test
    public void testFooterCategoryPage() {
        WebDriver driver = new ChromeDriver();
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }

    @Test
    public void testFooterRegisterPage() {
    }

    @Test
    public void testFooterLoginPage() {
    }

    public void testFooterColumn(FooterColumnComponent footerColumnComp) {
        System.out.println(footerColumnComp.headerElem().getText());
        footerColumnComp.linksElem().forEach(link -> {
            System.out.println(link.getAttribute("href"));
        });
    }

}
