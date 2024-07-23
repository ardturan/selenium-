package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForClick(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    }
    public static void waitVisibility(WebDriver driver,WebElement visibleElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click")));
    }

    public static void methodImplicitWait(){
        DriverUtils.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
