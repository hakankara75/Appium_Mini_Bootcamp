package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Day_03_Gesture_Page {

    public Day_03_Gesture_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(accessibility = "Kitapyurdu Türkiye Okur Ödülleri 2023 Kazanan Kitaplar Belirlendi")
    public WebElement kampanyalar;


}
