package stepdefinitions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import pages.Day_03_Gesture_Page;
import utilities.ReusableMethods;

import java.io.File;

import static utilities.Driver.getDriver;

public class Day_03_Gesture_StepDef {

    Day_03_Gesture_Page page=new Day_03_Gesture_Page();
    @And("click on kampanyalar")
    public void clickOnKampanyalar() {

        ReusableMethods.clickGesture(getDriver(),page.kampanyalar);


    }


    @Given("go to general store apk")
    public void goToGeneralStoreApk() {
    }

    @And("click on dropdown")
    public void clickOnDropdown() {
        page.country.click();

    }

    @And("seleck angola")
    public void seleckAngola() {
        page.angola.click();
        ReusableMethods.wait(2);
    }

    @And("send {string} to your name")
    public void sendToYourName(String arg0) {
        page.yourname.sendKeys(arg0);

    }

    @And("double click on tex")
    public void doubleClickOnTex() {
        ReusableMethods.wait(2);
        ReusableMethods.doubleClickWithCoordinates(getDriver(),205,991);

    }

    @And("click on copy")
    public void clickOnCopy() {
        ReusableMethods.wait(2);
        ReusableMethods.doubleClickWithCoordinates(getDriver(),242,895);

    }


    @Given("go to photos")
    public void goToPhotos() {
    }

    @And("click on second photo")
    public void clickOnSecondPhoto() {
        page.secondPhoto.click();

    }

    @And("double click on photo")
    public void doubleClickOnPhoto() {
        ReusableMethods.doubleClickWithCoordinates(getDriver(),457,1160);
    }
}
