package model.test_model;

import model.pages.LoginPageMod01;
import model.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPOM01 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        LoginPageMod01 loginPageMod01 = new LoginPageMod01(driver);
        driver.get("https://the-internet.herokuapp.com/login");

        loginPageMod01.username().sendKeys("tomsmith");
        loginPageMod01.password().sendKeys("SuperSecretPassword!");
        loginPageMod01.login().click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
