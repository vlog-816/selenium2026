package model.components.global.header;

import model.components.Component;
import model.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".header")
public class HeaderComponent extends Component {

    private final By shoppingCartSel = By.cssSelector("#topcartlink");

    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickOnShoppingCart(){
        WebElement shoppingCartElem = component.findElement(shoppingCartSel);
        scrollUpToElement(shoppingCartElem);
        shoppingCartElem.click();
    }


}
