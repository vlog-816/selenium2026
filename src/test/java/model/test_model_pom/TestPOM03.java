package model.test_model_pom;

import model.components.LoginPageComponent;
import model.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPOM03 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

//        LoginPageMod03 loginPageMod03 = new LoginPageMod03(driver);
//        loginPageMod03.loginPageComp().username();
//        loginPageMod03.loginPageComp().password();
//        loginPageMod03.loginPageComp().login();

        LoginPageComponent loginPageComp = new LoginPageMod03(driver).loginPageComp();
        loginPageComp.username("tomsmith");
        loginPageComp.password("SuperSecretPassword!");
        loginPageComp.login();

    }
}
