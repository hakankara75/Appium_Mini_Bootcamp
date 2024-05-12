package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Day05_Scroll_Page {
    public Day05_Scroll_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(id = "android:id/content")
    public WebElement page;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Splitting Touches across Views\")")
    public WebElement splittingTouches;
    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> elements;
    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/linearHome")
    public WebElement kitapYurduPage;
    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/imageView")
    public  List<WebElement>  kitapYurduReklam;
}
