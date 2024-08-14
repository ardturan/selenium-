package Lesson15Homework.runner;

import Lesson15Homework.driver.Driver;
import Lesson15Homework.driver.WaitUtils;
import Lesson15Homework.pages.HomePage;
import Lesson15Homework.pages.ItemPage;
import Lesson15Homework.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Driver {
    HomePage homePage;
    LoginPage loginPage;
    ItemPage itemPage;
    WaitUtils waitUtils ;

    @Test(priority = 1)//( groups = "LoginTestt")
    public void loginTest(){

        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.ClickPopUp();
        homePage.hoverGirisYapButton();
        homePage.clickGirisButton();
        loginPage.typeEmailOnEmailBox("ardturan1@gmail.com");
        loginPage.typePasswordOnPasswordBox("Arda1234arda");
        loginPage.clickLoginButton();
        homePage.quitDriver();




    }

    @Test(priority = 2)//(groups = "LoginTestt")
    public void InvalidLoginTest(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.ClickPopUp();
        homePage.hoverGirisYapButton();
        homePage.clickGirisButton();
        loginPage.typeEmailOnEmailBox(".com");
        loginPage.typePasswordOnPasswordBox("014");
        loginPage.clickLoginButton();
        loginPage.loginError("Lütfen geçerli bir e-posta adresi giriniz.");
        homePage.quitDriver();
    }

    @Test(priority = 3)
    public void SearchTest(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.ClickPopUp();
        homePage.typeTextSearchBox("elbise");
        homePage.ClickSearchButton();
        homePage.quitDriver();
    }

    @Test(priority = 4)
    public void NumberOfResultsTest() throws InterruptedException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        waitUtils = new WaitUtils();
        homePage.ClickPopUp();
        homePage.hoverGirisYapButton();
        homePage.clickGirisButton();
        loginPage.typeEmailOnEmailBox("nturan10@gmail.com");
        loginPage.typePasswordOnPasswordBox("bgs2014");
        loginPage.clickLoginButton();
        Thread.sleep(10000);
        //waitUtils.waitForClick(driver, waitUtils.inputField);
        homePage.typeTextSearchBox("elbise");
        //waitUtils.waitVisibility(driver);
        homePage.ClickSearchButton();
        homePage.getResults();
        homePage.quitDriver();

    }

    @Test(priority = 5)
    public void addBasketElbise() throws InterruptedException {
       itemPage = new ItemPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.ClickPopUp();
        homePage.hoverGirisYapButton();
        homePage.clickGirisButton();
        loginPage.typeEmailOnEmailBox("nturan10@gmail.com");
        loginPage.typePasswordOnPasswordBox("bgs2014");
        loginPage.clickLoginButton();
        Thread.sleep(5000);
        homePage.typeTextSearchBox("elbise");
        homePage.ClickSearchButton();
        homePage.ClickTheItem(0);
        Thread.sleep(10000);
        itemPage.moveToOtherPage(1);

        itemPage.AddToBasket();
        homePage.quitDriver();
    }

}
