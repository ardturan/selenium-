package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class    DriverUtils {

    public static WebDriver driver;

    // method to initalize method driver
    public static void initDriver(){
        if(driver == null){
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();


    }

    //method to get webdriver
    public static WebDriver getDriver(){
        if (driver == null){
            throw new IllegalStateException("Driver is not initalized, call initDriver() first ");
        }
        return driver;
    }

    //method to quit webdriver
    public static void quitDirver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }

    }
}
