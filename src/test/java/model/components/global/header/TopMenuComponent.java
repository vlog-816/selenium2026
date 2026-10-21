package model.components.global.header;

import model.components.Component;
import model.components.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@ComponentCssSelector(value = ".top-menu")
public class TopMenuComponent extends Component {

    public TopMenuComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<MainCatItems> mainCatItemsElem(){
        return findComponents(MainCatItems.class, driver);
    }

    @ComponentCssSelector(".top-menu > li")
    public static class MainCatItems extends Component
    {
        public MainCatItems(WebDriver driver, WebElement component) {
            super(driver, component);
        }

        public WebElement sublistLinkElem(){
            return findElement(By.tagName("a"));
        }

        public List<SublistComponent> sublistComps(){

            Actions actions = new Actions(driver);
            actions.moveToElement(component).perform();

            return findComponents(SublistComponent.class, driver);
        }
    }

    @ComponentCssSelector(value = ".sublist > li > a")
    public static class SublistComponent extends Component {
        public SublistComponent(WebDriver driver, WebElement component) {
            super(driver, component);
        }
    }
}
