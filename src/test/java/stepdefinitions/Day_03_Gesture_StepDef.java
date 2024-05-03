package stepdefinitions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.Day_03_Gesture_Page;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class Day_03_Gesture_StepDef {

    Day_03_Gesture_Page page=new Day_03_Gesture_Page();
    @And("click on kampanyalar")
    public void clickOnKampanyalar() {
        ReusableMethods.clickGesture(getDriver(),page.kampanyalar);


    }




}
