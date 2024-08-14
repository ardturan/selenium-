package Lesson15Homework.pages;

import Lesson15Homework.driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.lang.reflect.Type;

public class LoginPage extends Driver {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login-email")
    private WebElement email;

    @FindBy(id = "login-password-input")
    private  WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='message' and text()='Lütfen geçerli bir e-posta adresi giriniz.']")
    private WebElement loginErrorMessage;

    public void typeEmailOnEmailBox(String Email){

        email.sendKeys(Email);
    }

    public void typePasswordOnPasswordBox(String Password){

        password.sendKeys(Password);
    }

    public void clickLoginButton(){

        loginButton.click();
    }

    public String loginError (String ExpectedLoginErrorMessage ){
        Assertions.assertEquals(ExpectedLoginErrorMessage , loginErrorMessage.getText());
       // System.out.println(ExpectedLoginErrorMessage);
        return ExpectedLoginErrorMessage ;
    }

}
