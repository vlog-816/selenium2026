package model.components.global.footer;

import model.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.my-account")
public class MyAccountColumnComponent extends FooterColumnComponent{

    public MyAccountColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
