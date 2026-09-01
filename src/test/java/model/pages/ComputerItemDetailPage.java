package model.pages;

import model.components.computer.ComputerEssentialComponent;
import org.openqa.selenium.WebDriver;

public class ComputerItemDetailPage extends BasePage{

    public ComputerItemDetailPage(WebDriver driver) {
        super(driver);
    }

    public <T extends ComputerEssentialComponent> T computerComp(Class<T> componentEssentialClass){
        return findComponent(componentEssentialClass, driver);
    }
}