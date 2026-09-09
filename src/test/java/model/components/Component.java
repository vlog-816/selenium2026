package model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Component {

    protected WebDriver driver;
    protected WebElement component;
    protected WebDriverWait wait;
    private String cssSelector;

    public Component(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
    }

    public WebElement getComponent() {
        return component;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public <T extends Component> T findComponent(Class<T> classComponent, WebDriver driver) {

        T component = findComponents(classComponent, driver).get(0);

        if (component == null) {
            throw new IllegalArgumentException("Can not find the Component: " + classComponent.toString());
        }

        return component;
    }

    public <T extends Component> List<T> findComponents(Class<T> classComponent, WebDriver driver) {
        By componentSelector;

        try {
            componentSelector = getCompSelector(classComponent);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("[ERR] You need to provide an Annotation");
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(componentSelector));
        List<WebElement> results = component.findElements(componentSelector);

        Constructor<T> constructor;
        try {
            constructor = classComponent.getConstructor(WebDriver.class, WebElement.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("[ERR]The Component must have a constructor with params: WebDriver, WebElement");
        }

        List<T> components = results.stream().map(webElement -> {

            try {
                return constructor.newInstance(driver, webElement);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }).collect(Collectors.toList());
        return components;
    }

    private By getCompSelector(Class<? extends Component> componentClass) {

        if (componentClass.isAnnotationPresent(ComponentCssSelector.class)) {
            return By.cssSelector(componentClass.getAnnotation(ComponentCssSelector.class).value());
        } else if (componentClass.isAnnotationPresent(ComponentXpathSelector.class)) {
            return By.xpath(componentClass.getAnnotation(ComponentXpathSelector.class).value());
        } else {
            throw new IllegalArgumentException("The Component must contain Annotation Selector: " +
                    ComponentCssSelector.class.getSimpleName() +
                    ComponentXpathSelector.class.getSimpleName());
        }
    }

    public void scrollUpToElement(WebElement element) {
        scrollToElement("false", element);
    }

    public void scrollDownToElement(WebElement element) {
        scrollToElement("true", element);
    }

    private void scrollToElement(String position, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + position + ");", element);
    }


}