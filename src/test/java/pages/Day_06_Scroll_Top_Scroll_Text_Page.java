package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Day_06_Scroll_Top_Scroll_Text_Page {

    public Day_06_Scroll_Top_Scroll_Text_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/linearHome")
    public WebElement mainPage;

    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/recyclerViewList")
    public List<WebElement> ayinYazarlari;
    @AndroidFindBy(accessibility = "API Demos")
    public WebElement apiDemos;
}
