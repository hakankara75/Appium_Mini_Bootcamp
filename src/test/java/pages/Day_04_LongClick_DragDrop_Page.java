package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Day_04_LongClick_DragDrop_Page {


    public Day_04_LongClick_DragDrop_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(accessibility = "Spotify")
    public WebElement spotify;
    @AndroidFindBy(accessibility = "Müslüm Gürses Mix - Playlist")
    public WebElement muslum;
    @AndroidFindBy(accessibility = "Search")
    public WebElement search;
    @AndroidFindBy(accessibility = "Views")
    public WebElement views;
    @AndroidFindBy(accessibility = "Drag and Drop")
    public WebElement dragDrop;
    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    public WebElement dragObject;

}
