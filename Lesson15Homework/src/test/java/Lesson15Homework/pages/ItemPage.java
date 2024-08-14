package Lesson15Homework.pages;

import Lesson15Homework.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ItemPage extends Driver {

    public ItemPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(className = "add-to-basket")
    WebElement addToBAsketButton;


    public void AddToBasket(){

        addToBAsketButton.click();

    }


    public void moveToOtherPage(int i ){
        ArrayList<String> tabs = new ArrayList<String> (Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs.get(i));

    }

}
