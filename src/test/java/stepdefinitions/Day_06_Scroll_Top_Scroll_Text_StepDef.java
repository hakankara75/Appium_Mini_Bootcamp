package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.Day_06_Scroll_Top_Scroll_Text_Page;

import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.*;

public class Day_06_Scroll_Top_Scroll_Text_StepDef {

    Day_06_Scroll_Top_Scroll_Text_Page page= new Day_06_Scroll_Top_Scroll_Text_Page();


    @And("scroll end of the main page")
    public void scrollEndOfTheMainPage() {
        scrollToTheDownOfThePage(getDriver(),page.mainPage,1);
    }

    @And("scroll top of the page")
    public void scrollTopOfThePage() {
        scrollToTheTopOfThePage(getDriver(),page.ayinYazarlari.get(0),1);

    }


    @And("click on api demos apk")
    public void clickOnApiDemosApk() {
        page.apiDemos.click();
    }

    @And("scroll to rotating button")
    public void scrollToRotatingButton() {
        String text="Rotating Button";
        scrollToElementWithText(getDriver(),text);

    }



}
