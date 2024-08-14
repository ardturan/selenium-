package Lesson15Homework.driver;

import Lesson15Homework.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils extends Driver{

    @FindBy(className = "V8wbcUhU")
    public WebElement inputField;



    public WaitUtils() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public  void waitForClick(WebDriver driver,WebElement inputField){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(inputField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

    }

    public  void waitVisibility(WebDriver driver ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("V8wbcUhU")));
    }

    public  void methodImplicitWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
