package test;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    public void initBrowser() {
        driver = new ChromeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) driver.quit();
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            // 1. Lấy tên của test case vừa chạy
            String methodName = result.getMethod().getMethodName();

            // 2. Lấy thời gian hiện tại và format theo chuẩn bạn muốn
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            String time = LocalDateTime.now().format(formatter);

            // 3. Ghép tên hàm và thời gian lại với nhau
            String imageName = methodName + "_" + time;

            System.out.println("Test failed! Taking screenshot: " + imageName);

            // 4. Chụp ảnh và đính kèm vào Allure với tên vừa tạo
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(imageName, new ByteArrayInputStream(screenshot));
        }
    }

}
