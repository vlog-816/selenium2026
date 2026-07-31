package test_flows.global;

import model.components.global.footer.FooterColumnComponent;

import static model.components.global.header.TopMenuComponent.MainCatItems;
import static model.components.global.header.TopMenuComponent.SublistComponent;

import model.components.global.header.TopMenuComponent;
import model.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.*;

public class FooterTestFlow {

    private WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {

        BasePage basePage = new BasePage(driver);

        verifyInformationColumn(basePage.footerComp().informationColumnComp());
        verifyCustomerServiceColumn();
        verifyMyAccountColumn();
        verifyFollowUsColumn();
    }

    private void verifyInformationColumn(FooterColumnComponent footerColumnComp) {

        List<String> expectedText = new ArrayList<>(Arrays.asList(
                "Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us"));
        List<String> expectedHref = new ArrayList<>(Arrays.asList(
                "https://demowebshop.tricentis.com/sitemap",
                "https://demowebshop.tricentis.com/shipping-returns",
                "https://demowebshop.tricentis.com/privacy-policy",
                "https://demowebshop.tricentis.com/conditions-of-use",
                "https://demowebshop.tricentis.com/about-us",
                "https://demowebshop.tricentis.com/contactus"
        ));
        testFooterColumn(footerColumnComp, expectedText, expectedHref);

    }

    private void verifyCustomerServiceColumn() {
    }

    private void verifyMyAccountColumn() {
    }

    private void verifyFollowUsColumn() {
    }

    public void verifyProductCatComponent() {

        BasePage basePage = new BasePage(driver);
        TopMenuComponent topMenuComp = basePage.topMenuComp();

        List<MainCatItems> mainCatsElem = topMenuComp.mainCatItemsElem();
        if (mainCatsElem.isEmpty()) {
            Assert.fail("[Err] Category items is empty");
        }

        MainCatItems mainCatItemsRandom = mainCatsElem.get(new SecureRandom().nextInt(mainCatsElem.size()));
        String hrefRandom = mainCatItemsRandom.sublistLinkElem().getAttribute("href");

        List<SublistComponent> sublistComps = mainCatItemsRandom.sublistComps();

        if (sublistComps.isEmpty()) {
            mainCatItemsRandom.getComponent().click();
        } else {
            SublistComponent catItemCompRandom = sublistComps.get(new SecureRandom().nextInt(sublistComps.size()));
            catItemCompRandom.getComponent().click();
            hrefRandom = catItemCompRandom.getComponent().getAttribute("href");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(hrefRandom));

        verifyFooterComponent();

    }


    public void testFooterColumn(FooterColumnComponent footerColumnComp, List<String> expectedText, List<String> expectedHref) {

        List<String> actualText = new ArrayList<>();
        List<String> actualHref = new ArrayList<>();

        footerColumnComp.linksElem().forEach(link -> {
            actualText.add(link.getText().trim());
            actualHref.add(link.getAttribute("href"));
        });

        if (actualText.isEmpty() || actualHref.isEmpty()) {
            Assert.fail("[Err] Text or href is empty in footer column ");
        }

        Assert.assertEquals(actualText, expectedText, "[Err] Actual and Expected text are different");
        Assert.assertEquals(actualHref, expectedHref, "[Err] [Err] Actual and Expected href are different");
    }
}
