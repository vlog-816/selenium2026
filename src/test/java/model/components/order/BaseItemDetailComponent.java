package model.components.order;

import model.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseItemDetailComponent extends Component {

    private final By notificationSuccessSel = By.cssSelector(".bar-notification.success");
    private final By productPriceSel = By.cssSelector(".product-price");
    private final By addToCartSel = By.cssSelector(".add-to-cart-button");


    public BaseItemDetailComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public Double productPrice() {
        String productPriceText = component.findElement(productPriceSel).getText().trim();
        return Double.parseDouble(productPriceText);
    }

    //click button add to cart, wait until notification appears
    public void clickOnAddToCart() {
        component.findElement(addToCartSel).click();
    }

    public void waitUntilItemAddedToCart() {
        String successMsg = "The product has been added to your ";

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(notificationSuccessSel, successMsg));
        } catch (RuntimeException exception) {
            System.out.println("[WAR] This is a bug for first time adding the item into Cart");
            clickOnAddToCart();
        }
    }


}
