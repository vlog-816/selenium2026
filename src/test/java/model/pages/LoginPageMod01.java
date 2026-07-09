package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageMod01 {

    private WebDriver driver;
    private By usernameSel = By.id("username");
    private By passwordSel = By.id("password");
    private By loginSel = By.cssSelector("[type=\"submit\"]");

    public LoginPageMod01(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement username(){
        return driver.findElement(usernameSel);
    }

    public WebElement password(){
        return driver.findElement(passwordSel);
    }

    public WebElement login(){
        return driver.findElement(loginSel);
    }
}
