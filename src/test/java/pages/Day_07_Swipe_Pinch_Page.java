package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Day_07_Swipe_Pinch_Page {

    public Day_07_Swipe_Pinch_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> apiDemos;
    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/recyclerViewList")
    public List<WebElement> ilgiGorenler;
    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/linearHome")
    public WebElement kitapYurduMainPage;
    @AndroidFindBy(id = "com.mobisoft.kitapyurdu:id/imageViewProduct")
    public List<WebElement> books;
    @AndroidFindBy(id = "trendyol.com:id/imageViewProduct")
    public List<WebElement> trendyolProducts;
    @AndroidFindBy(id = "trendyol.com:id/imageview_product_detail_slider")
    public WebElement firstImage;
    @AndroidFindBy(id = "trendyol.com:id/photoViewImage")
    public WebElement readyZoom;
}
