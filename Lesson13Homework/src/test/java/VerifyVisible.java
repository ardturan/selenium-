import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class VerifyVisible {

    @BeforeClass
    public static void loginPage() {
        DriverUtils.initDriver();
        DriverUtils.getDriver().get("https://demoqa.com/dynamic-properties ");
    }
    @Test
    public static void verifyVisibleButton(){
        WebElement enableButton = DriverUtils.getDriver().findElement(By.id("enableAfter"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        WebElement visibleAfter = DriverUtils.getDriver().findElement(By.id("visibleAfter"));
        assert visibleAfter.getText().equals("Visible After 5 Seconds");

        DriverUtils.quitDirver();
    }
}
