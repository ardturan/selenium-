package Lesson15Homework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.time.Duration;

public class Driver {

    protected static WebDriver driver;
    SoftAssert softAssert;
    Actions actions;

    //@Parameters({"browser"})
    @BeforeClass
    public void Setup(){

        //switch (browser)
        //{
           // case "chrome":

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.trendyol.com/");
            softAssert = new SoftAssert();
               // break;
            //case "edge":

               // driver = new EdgeDriver();
                //driver.manage().window().maximize();
                //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                //driver.get("https://www.trendyol.com/");
                //softAssert = new SoftAssert();
                //break;
            //default:
              //  throw new IllegalStateException("Unexpected value: " );
        //}

    }

    public static WebDriver getDriver(){

        return driver;
    }

    @AfterClass
    public void tearDown(){

        softAssert.assertAll();
    }

    public void MoveToElement(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();

    }
    public void ClickPopUp(WebElement element){
        element.click();
    }
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }
}
