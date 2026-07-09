package model.pages;

import model.components.LoginPageComponent;
import org.openqa.selenium.WebDriver;

public class LoginPageMod03 {

    private WebDriver driver;

    public LoginPageMod03(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageComponent loginPageComp(){
        return new LoginPageComponent(driver);
    }
}
