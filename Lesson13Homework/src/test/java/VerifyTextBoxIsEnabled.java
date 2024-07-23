import Utils.DriverUtils;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.Message;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyTextBoxIsEnabled {

    @BeforeClass
    public static void loginPage() {
        DriverUtils.initDriver();
        DriverUtils.getDriver().get(" https://the-internet.herokuapp.com/dynamic_controls");
    }
    @Test
    public static void textBoxIsEnabled(){

        WebElement textBox = DriverUtils.driver.findElement(By.xpath("//input[@type='text']"));
        assert !textBox.isEnabled();

        if(textBox.isEnabled() ){
            throw new IllegalArgumentException("text box is enable");
        }

        WebElement enableButton = DriverUtils.driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(DriverUtils.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        WebElement enabledMessage = DriverUtils.getDriver().findElement(By.id("message"));
        assert enabledMessage.getText().equals("It's enabled!");

       assert textBox.isEnabled();

       DriverUtils.quitDirver();

    }
}