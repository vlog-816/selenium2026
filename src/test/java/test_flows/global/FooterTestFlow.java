package test_flows.global;

import model.components.global.footer.FooterColumnComponent;
import org.openqa.selenium.WebDriver;

public class FooterTestFlow {

    private WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(){
        verifyInformationColumn();
        verifyCustomerServiceColumn();
        verifyMyAccountColumn();
        verifyFollowUsColumn();
            }

    private void verifyInformationColumn() {
    }

    private void verifyCustomerServiceColumn() {
    }

    private void verifyMyAccountColumn() {
    }

    private void verifyFollowUsColumn() {
    }

    public void testFooterColumn(FooterColumnComponent footerColumnComp) {
        System.out.println(footerColumnComp.headerElem().getText());
        footerColumnComp.linksElem().forEach(link -> {
            System.out.println(link.getAttribute("href"));
        });
    }
}
