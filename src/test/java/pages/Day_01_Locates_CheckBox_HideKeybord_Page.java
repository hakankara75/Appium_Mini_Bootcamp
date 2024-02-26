package test.java.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.List;

public class Day_01_Locates_CheckBox_HideKeybord_Page {
    public Day_01_Locates_CheckBox_HideKeybord_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> apiDemos;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"API Demos\")")
    public WebElement apiDemosText;
    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> accessibilityNodeQuerying;
    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> accessibilityElements;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@resource-id=\"com.touchboarder.android.api.demos:id/tasklist_finished\"])[2]")
    public WebElement conquerWorld;
    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/tasklist_finished")
    public List<WebElement> checkBoxes;
}
