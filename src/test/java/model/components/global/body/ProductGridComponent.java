package model.components.global.body;

import model.components.Component;
import model.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


@ComponentCssSelector(".product-grid")
public class ProductGridComponent extends Component {

    public ProductGridComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<ProductItemComponent> productItemComps() {
        return findComponents(ProductItemComponent.class, driver);
    }


}
