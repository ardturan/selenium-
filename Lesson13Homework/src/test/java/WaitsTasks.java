import Utils.DriverUtils;
import Utils.WaitUtils;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

import static Utils.DriverUtils.*;

public class WaitsTasks {

    @BeforeClass
    public static void loginPage(){
        DriverUtils.initDriver();
        DriverUtils.getDriver().get(" https://the-internet.herokuapp.com/dynamic_controls");


    }
    @Test
    public void implictWait(){
        WebElement removeButton = DriverUtils.getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();

        WaitUtils.methodImplicitWait();


        WebElement message1 = DriverUtils.getDriver().findElement(By.id("message"));
        assert message1.getText().equals("It's gone!");

        WebElement addButton = DriverUtils.getDriver().findElement(By.xpath("//button[contains(text(),'Add')]"));
        addButton.click();

       WaitUtils.methodImplicitWait();

        WebElement message2 = DriverUtils.getDriver().findElement(By.id("message"));
        assert message2.getText().equals("It's back!");

        WaitUtils.methodImplicitWait();
        DriverUtils.quitDirver();

    }


    @Test
    public void explicitWait(){
        WebElement removeButton = DriverUtils.getDriver().findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();

        WaitUtils.waitForClick(driver,removeButton);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        WebElement message1 = DriverUtils.getDriver().findElement(By.id("message"));
        assert message1.getText().equals("It's gone!");



        WebElement addButton = DriverUtils.getDriver().findElement(By.xpath("//button[contains(text(),'Add')]"));
        addButton.click();

        WaitUtils.waitForClick(driver,addButton );

        WebElement message2 = DriverUtils.getDriver().findElement(By.id("message"));
        assert message2.getText().equals("It's back!");



        DriverUtils.quitDirver();

    }


}
