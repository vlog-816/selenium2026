package model.pages;

import model.components.Component;
import model.components.global.header.HeaderComponent;
import model.components.global.body.ProductGridComponent;
import model.components.global.footer.FooterComponent;
import model.components.global.header.TopMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Component {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    public HeaderComponent headerComp(){
        return findComponent(HeaderComponent.class, driver);
    }

    public TopMenuComponent topMenuComp(){
        return findComponent(TopMenuComponent.class, driver);
    }

    public ProductGridComponent productGridComp(){
        return findComponent(ProductGridComponent.class, driver);
    }

    public FooterComponent footerComp(){
        return findComponent(FooterComponent.class, driver);
    }

}
