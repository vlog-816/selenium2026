package model.components.global.footer;

import model.components.Component;
import model.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".footer")
public class FooterComponent extends Component {
    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public InformationColumnComponent informationColumnComp() {
        return findComponent(InformationColumnComponent.class, driver);
    }

    public CustomerServiceColumnComponent customerServiceColumnComp() {
        return findComponent(CustomerServiceColumnComponent.class, driver);
    }

    public MyAccountColumnComponent myAccountColumnComp() {
        return findComponent(MyAccountColumnComponent.class, driver);
    }

    public FollowUsColumnComponent followUsColumnComp() {
        return findComponent(FollowUsColumnComponent.class, driver);
    }
}
