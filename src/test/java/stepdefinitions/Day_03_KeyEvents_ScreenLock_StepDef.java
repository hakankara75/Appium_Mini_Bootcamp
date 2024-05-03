package stepdefinitions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Day_03_KeyEvents_ScreenLock_Page;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class Day_03_KeyEvents_ScreenLock_StepDef {


    Day_03_KeyEvents_ScreenLock_Page page= new Day_03_KeyEvents_ScreenLock_Page();

    @Given("go to main page")
    public void goToMainPage() {

    }

    @And("click on spotify apk")
    public void clickOnSpotifyApk() {
        page.spotify.click();
    }

    @And("click on Baris Manco")
    public void clickOnBarisManco() {
        page.barisMuslum.get(0).click();
    }

    @And("click on play")
    public void clickOnPlay() {
        page.playAndPause.click();
    }

    @And("volume up")
    public void volumeUp() {
        KeyEvent volume= new KeyEvent(AndroidKey.VOLUME_UP);
        getDriver().pressKey(volume);
        getDriver().pressKey(volume);
        getDriver().pressKey(volume);

        ReusableMethods.wait(3);
    }

    @And("volume down")
    public void volumeDown() {
        KeyEvent volume= new KeyEvent(AndroidKey.VOLUME_DOWN);
        getDriver().pressKey(volume);
        getDriver().pressKey(volume);
        getDriver().pressKey(volume);
        ReusableMethods.wait(3);
    }

    @And("back to main page")
    public void backToMainPage() {
        KeyEvent back= new KeyEvent(AndroidKey.BACK);
        getDriver().pressKey(back);
        ReusableMethods.wait(2);
    }

    @And("click on Muslum Gurses")
    public void clickOnMuslumGurses() {
        page.barisMuslum.get(1).click();
        ReusableMethods.wait(5);
    }

    @And("volume off")
    public void volumeOff() {
//        try {
//            KeyEvent mute= new KeyEvent(AndroidKey.VOLUME_MUTE);
//            getDriver().pressKey(mute);
//        }catch (Exception e){
//
//        }

        ReusableMethods.wait(5);
    }

    @Then("stop the music")
    public void stopTheMusic() {

        try {
        page.playAndPause.click();
        }catch (Exception e){

        }

        ReusableMethods.wait(2);

    }


}
