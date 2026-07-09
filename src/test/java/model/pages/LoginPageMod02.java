package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMod02 {

    private WebDriver driver;
    private By usernameSel = By.id("username");
    private By passwordSel = By.cssSelector("#password");
    private By loginSel = By.cssSelector("[type=\"submit\"]");

    public LoginPageMod02(WebDriver driver) {
        this.driver = driver;
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
