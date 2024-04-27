package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Day_02_ToastMessage_HideKeyboard_Page {
    public Day_02_ToastMessage_HideKeyboard_Page(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    //n11 Locates
    @AndroidFindBy(id = "com.dmall.mfandroid:id/navigation_bar_item_icon_view")
    public List<WebElement> hesabim;
    @AndroidFindBy(id = "com.dmall.mfandroid:id/btn_login")
    public WebElement girisYap;
    @AndroidFindBy(id = "com.dmall.mfandroid:id/text_input_edit_text")
    public WebElement email;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.dmall.mfandroid:id/btn_login\"]")
    public WebElement girisYapSecond;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Şifre\")")
    public WebElement sifre;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"E-posta adresi veya şifre hatalı, kontrol edebilir misin?\")")
    public WebElement message;

    //Blabla locates
    @AndroidFindBy(id = "com.comuto:id/edit_text_input")
    public List<WebElement> epostaSifre;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Giriş yap\")")
    public WebElement giris;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Girdiğin kullanıcı adı veya parola yanlış.\")")
    public WebElement errorMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.comuto:id/button_text\" and @text=\"Giriş yap\"]")
    public WebElement girisYapFirst;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"E-posta ile devam et\")")
    public WebElement eposta;
}
