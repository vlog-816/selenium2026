package model.test_model;

import model.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPOM02 {
    public static void main(String[] args) {

        WebDriver firefoxDriver = new FirefoxDriver();
        LoginPageMod02 loginPageMod02 = new LoginPageMod02(firefoxDriver);
        firefoxDriver.get("https://the-internet.herokuapp.com/login");

        loginPageMod02.username("tomsmith");
        loginPageMod02.password("SuperSecretPassword!");
        loginPageMod02.login();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        firefoxDriver.quit();
    }
}
