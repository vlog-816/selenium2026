package model.components.computer;

import model.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseItemDetailComponent extends Component {

    private final By productPriceSel = By.cssSelector(".product-price");

    public BaseItemDetailComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public Double productPrice(){
        String price = driver.findElement(productPriceSel).getText().trim();
        return Double.parseDouble(price);
    }

}
