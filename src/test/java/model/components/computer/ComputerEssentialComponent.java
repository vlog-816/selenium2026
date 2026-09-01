package model.components.computer;

import model.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ComputerEssentialComponent extends Component {
    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessorType(String type);

    public abstract String selectRAMType(String type);

    public String selectHDDType(String type) {
        return selectCompOpt(type);
    }

    public String selectOSType(String type) {
        return selectCompOpt(type);
    }

    protected String selectCompOpt(String type) {

        String selectorString = "//label[contains(text(), \"" + type + "\")]";

        WebElement optionElem = null;

        try {
            optionElem = component.findElement(By.xpath(selectorString));

        } catch (Error ignored) {
        }

        if (optionElem != null) {
            optionElem.click();
            return optionElem.getText();
        } else throw new RuntimeException(type + " is not existing to select");

    }
}
