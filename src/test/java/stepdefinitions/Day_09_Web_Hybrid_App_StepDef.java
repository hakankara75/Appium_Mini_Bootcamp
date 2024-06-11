package stepdefinitions;

import io.cucumber.java.en.And;
import pages.Day_09_Web_Hybrid_App_Page;
import utilities.ReusableMethods;

import java.util.Set;

import static utilities.Driver.getDriver;

public class Day_09_Web_Hybrid_App_StepDef {

    Day_09_Web_Hybrid_App_Page page=new Day_09_Web_Hybrid_App_Page();


    @And("click on web view")
    public void clickOnWebView() {
        ReusableMethods.scrollToElementWithText(getDriver(), "WebView");

        Set<String> set= getDriver().getContextHandles();

        for (String app: set){
            System.out.println("app = " + app);
        }

        page.webView.click();

    }

    @And("send {string} to textbox")
    public void sendToTextbox(String arg0) {
        Set<String> set= getDriver().getContextHandles();

        for (String app: set){
            System.out.println("app = " + app);
        }

        getDriver().context("WEBVIEW_io.appium.android.apis"); //context() ile native den web'e geçiş yaparım

        ReusableMethods.wait(2);

        page.textbox.click();
        page.textbox.sendKeys(arg0);



    }
}
