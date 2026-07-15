package test_loginPageAbs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestLoginPage {

    public static void main(String[] args) {

        new TestLoginPage().login(InternalLoginPage.class);
        new TestLoginPage().login(ExternalLoginPage.class);
    }


    public <T extends LoginPage> void login(Class<T> loginPageClass) {
        try {
            Constructor<T>  constructor = loginPageClass.getConstructor(WebDriver.class);
            T loginPageObj = constructor.newInstance(new ChromeDriver());
            loginPageObj.login();

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
