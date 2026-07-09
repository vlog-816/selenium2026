package model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageComponent {

    private WebDriver driver;
    private By usernameSel = By.id("username");
    private By passwordSel = By.cssSelector("#password");
    private By loginSel = By.cssSelector("[type=\"submit\"]");

    public LoginPageComponent(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void username(String username){
        driver.findElement(usernameSel).sendKeys(username);
    }

    public void password(String password){
        driver.findElement(passwordSel).sendKeys(password);
    }

    public void login(){
        driver.findElement(loginSel).click();
    }
}
