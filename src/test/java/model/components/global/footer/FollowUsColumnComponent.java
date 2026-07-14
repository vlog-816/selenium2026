package model.components.global.footer;

import model.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.follow-us")
public class FollowUsColumnComponent extends FooterColumnComponent{
    public FollowUsColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
