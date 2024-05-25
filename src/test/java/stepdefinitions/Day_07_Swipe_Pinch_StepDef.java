package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.Day_07_Swipe_Pinch_Page;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.*;

public class Day_07_Swipe_Pinch_StepDef {


    Day_07_Swipe_Pinch_Page page=new Day_07_Swipe_Pinch_Page();

    String direction="up";
    String direction1="down";
    String direction2="left";
    String direction3="right";

    @And("swipe to left")
    public void swipeToLeft() {

        ReusableMethods.wait(3);
        String direction= "left";
        double percent= 1.0;
        int speed=500;
        swipeWithCoordinate(getDriver(),50,1333,1000,367,direction,percent,speed);

    }


    @And("swipe to top")
    public void swipeToTop() {
        swipe(getDriver(),page.kitapYurduMainPage,direction,1,1000);
    }

    @And("swipe with element")
    public void swipeWithElement() {
        swipe(getDriver(),page.ilgiGorenler.get(0),direction2,1,1000);
    }

    @And("fling down")
    public void flingDown() {
        fling(getDriver(), page.kitapYurduMainPage,direction1,50000 );
    }


    @And("fling left")
    public void flingLeft() {

        fling(getDriver(), page.books.get(3),direction2,7500 );
    }


    @Given("go to trendyol apk")
    public void goToTrendyolApk() {
    }

    @And("click on first product")
    public void clickOnFirstProduct() {
        page.trendyolProducts.get(0).click();
        page.firstImage.click();

    }

    @And("pinch open the image")
    public void pinchOpenTheImage() {
        pinchOpen(getDriver(),page.readyZoom,1,500);
    }

    @And("pinch close the image")
    public void pinchCloseTheImage() {

        pinchClose(getDriver(),page.readyZoom,1,500);
    }



}
