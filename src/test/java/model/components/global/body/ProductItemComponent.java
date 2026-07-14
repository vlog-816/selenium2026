package model.components.global.body;

import model.components.Component;
import model.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".product-item")
public class ProductItemComponent extends Component {

    private By productTitleSel = By.cssSelector(".product-title");

    public ProductItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement productTitleElem() {
        return component.findElement(productTitleSel);
    }

}
