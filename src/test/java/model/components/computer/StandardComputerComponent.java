package model.components.computer;

import model.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@ComponentCssSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent {

    private By productAttributeSel = By.cssSelector("select[id^=\"product_attribute\"]");

    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {

        final int PROCESSOR_INDEX = 0;
        WebElement processorDropdownElem = component.findElements(productAttributeSel).get(PROCESSOR_INDEX);

        return selectOption(processorDropdownElem, type);

    }

    @Override
    public String selectRAMType(String type) {

        final int RAM_INDEX = 1;
        WebElement ramDropdownElem = component.findElements(productAttributeSel).get(RAM_INDEX);

        return selectOption(ramDropdownElem, type);
    }

    private String selectOption(WebElement dropdownElement, String type) {
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();

        //loop in list option, if there is an option starts with type/a letter in type input, select it. If not throw error
        String fullOptString = null;

        for (WebElement option : options) {
            String currentOption = option.getText();
            String optionWithoutSpace = currentOption.trim().replaceAll(" ", "").toUpperCase();
            String typeWithoutSpace = type.trim().replaceAll(" ","").toUpperCase();

            if (optionWithoutSpace.startsWith(typeWithoutSpace)) {
                fullOptString = currentOption;
                break;
            }
        }

        if (fullOptString == null)
            throw new RuntimeException(type + "is not existing to select");

        select.selectByVisibleText(fullOptString);

        return fullOptString;
    }

}
