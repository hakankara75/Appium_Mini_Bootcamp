package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Day_03_KeyEvents_ScreenLock_Page {


    public Day_03_KeyEvents_ScreenLock_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    @AndroidFindBy(accessibility = "Spotify")
    public WebElement spotify;
    @AndroidFindBy(id = "com.spotify.music:id/image")
    public List<WebElement> barisMuslum;
    @AndroidFindBy(id = "com.spotify.music:id/button_play_and_pause")
    public WebElement playAndPause;


}
