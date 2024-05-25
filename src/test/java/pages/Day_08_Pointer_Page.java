package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Day_08_Pointer_Page {

    public Day_08_Pointer_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(id = "android:id/content")
    public WebElement page;
}
