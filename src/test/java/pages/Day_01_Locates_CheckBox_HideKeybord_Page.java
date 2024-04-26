package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
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
    @AndroidFindBy(accessibility = "Access'ibility")
    public WebElement accessibility;
    @AndroidFindBy(id = "android:id/text1")
    public WebElement nodequerying;
    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> accessibilityNodeQuerying;
    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> accessibilityElements;
    @AndroidFindBy(xpath = "(//android.widget.CheckBox[@resource-id=\"com.touchboarder.android.api.demos:id/tasklist_finished\"])[2]")
    public WebElement conquerWorld;
    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/tasklist_finished")
    public List<WebElement> checkBoxes;
    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/textViewListTitle")
    public List<WebElement> ilgiGorenler;



    @AndroidFindBy(className = "android.widget.TextView")
    public List<WebElement> n11MainPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.dmall.mfandroid:id/tvHomeSearchBar\"]")
    public WebElement searchBox;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.dmall.mfandroid:id/etSearch\"]")
    public WebElement searchBox2;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.dmall.mfandroid:id/viewSearchRV\"]/android.view.ViewGroup[2]/android.widget.LinearLayout")
    public WebElement erkekKazak;
    @AndroidFindBy(id = "com.dmall.mfandroid:id/listingFilterTV")
    public WebElement filtrele;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beden\")")
    public WebElement beden;
    @AndroidFindBy(className = "android.widget.CheckBox")
    public List<WebElement>  m;
}
