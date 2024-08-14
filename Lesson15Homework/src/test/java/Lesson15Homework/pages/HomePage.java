package Lesson15Homework.pages;

import Lesson15Homework.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Driver {

    @FindBy(css = ".modal-close")
    private WebElement homePagePopup;

    @FindBy(xpath = "//p[contains(text(),'Giriş Yap')] ")
    private  WebElement GirisYapLabel;

    @FindBy(css = ".login-button")
    private WebElement girisButton;

    @FindBy(className = "V8wbcUhU")
    private WebElement inputField;

    @FindBy(className = "cyrzo7gC")
    private WebElement searchbutton;

    @FindBy(xpath = "//div[@class='p-card-chldrn-cntnr card-border']")
    List<WebElement> searchResults;

    public HomePage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    public void ClickPopUp() {

        ClickPopUp(homePagePopup);
    }

    public void hoverGirisYapButton(){

        MoveToElement(GirisYapLabel);
    }

    public void clickGirisButton()  {


        girisButton.click();
    }
    public void clickSearchBox(){
        inputField.click();
    }

    public void typeTextSearchBox(String arama){
        inputField.sendKeys(arama);
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.textToBe(By.className("V8wbcUhU"),"elbise"));



    }

    public void ClickSearchButton() {

       searchbutton.click();
    }

    public void getResults(){
       int numberOfResults = searchResults.size();
        System.out.println("number of elbise search results = "+numberOfResults);



    }

    //public void moveToOtherPage(){
      //  ArrayList<String> tabs = new ArrayList<String> (Driver.driver.getWindowHandles());
        //Driver.driver.switchTo().window(tabs.get(1));

    //}
    public void ClickTheItem(int i){

        searchResults.get(i).click();
       // ArrayList<String> tabs = new ArrayList<String> (Driver.driver.getWindowHandles());
        //Driver.driver.switchTo().window(tabs.get(1));

    }

}
