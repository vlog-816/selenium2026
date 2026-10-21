package model.components.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ComputerEssentialComponent extends BaseItemDetailComponent {
    private final By allOptionSel = By.xpath("//input[@type=\"checkbox\"]");

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

    public String selectSoftWare(String type) {
        return selectCompOpt(type);
    }

    protected String selectCompOpt(String type) {

        String selectorString = "//label[contains(text(), \"" + type + "\")]";

        WebElement optionElem = null;

        try {
            optionElem = component.findElement(By.xpath(selectorString));

        } catch (Exception ignored) {
        }

        if (optionElem != null) {
            optionElem.click();
            return optionElem.getText();
        } else throw new RuntimeException(type + " is not existing to select");
    }

    public void unselectAllOptions() {
        List<WebElement> checkboxOpts = component.findElements(allOptionSel);

        for (WebElement checkbox : checkboxOpts) {
            if (checkbox.getAttribute("checked") != null) checkbox.click();
        }
    }

}
