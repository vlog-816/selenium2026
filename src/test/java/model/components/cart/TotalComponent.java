package model.components.cart;

import model.components.Component;
import model.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentCssSelector(".cart-footer .totals")
public class TotalComponent extends Component {

    private static final By priceTableRowSel = By.cssSelector("table.cart-total tr");
    private static final By cartTotalLeftSel = By.cssSelector(".cart-total-left");
    private static final By cartTotalRoghtSel = By.cssSelector(".cart-total-right");

    public TotalComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public Map<String, Double> priceCategories() {
        Map<String, Double> totalPrice = new HashMap<>();

        List<WebElement> cartTotalElem = component.findElements(priceTableRowSel);

        for (WebElement element : cartTotalElem) {
            String type = element.findElement(cartTotalLeftSel).getText().trim().replace(":", "");
            double value = Double.parseDouble(element.findElement(cartTotalRoghtSel).getText().trim());

            totalPrice.put(type, value);
        }

        return totalPrice;
    }

}
