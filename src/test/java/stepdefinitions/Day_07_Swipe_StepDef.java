package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import pages.Day_07_Swipe_Page;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.swipeWithCoordinate;

public class Day_07_Swipe_StepDef {


    Day_07_Swipe_Page page=new Day_07_Swipe_Page();

    @And("swipe to left")
    public void swipeToLeft() {

        ReusableMethods.wait(3);
        String direction= "left";
        double percent= 1.0;
        int speed=500;
        swipeWithCoordinate(getDriver(),50,1333,1000,367,direction,percent,speed);

    }




}
