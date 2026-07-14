package model.components.global.footer;

import model.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.information")
public class InformationColumnComponent extends FooterColumnComponent{

    public InformationColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
