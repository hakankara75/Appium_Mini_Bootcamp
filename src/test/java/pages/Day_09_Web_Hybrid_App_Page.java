package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Day_09_Web_Hybrid_App_Page {
    public Day_09_Web_Hybrid_App_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(accessibility = "WebView")
    public WebElement webView;
    @FindBy(id = "the_forms_id")
    public WebElement textbox;
}
