package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.Day_04_LongClick_DragDrop_Page;

import static org.junit.Assert.assertEquals;
import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.*;

public class Day_04_LongClick_DragDrop_StepDef {


    Day_04_LongClick_DragDrop_Page page=new Day_04_LongClick_DragDrop_Page();

    @When("long click on spotify apk")
    public void longClickOnSpotifyApk() {
       // longClick(getDriver(), page.spotify, 1);
        longClickWithCoordinates(getDriver(),945,2078 , 1);


    }
    @Then("verify {string} text")
    public void verifyText(String arg0) {
        String expectedText= arg0;
        String actualText= page.search.getText();
        System.out.println("actualText = " + actualText);
        assertEquals(expectedText, actualText);


    }


    @And("click on views")
    public void clickOnViews() {

        page.views.click();

    }

    @And("click on drag and drop")
    public void clickOnDragAndDrop() {
        page.dragDrop.click();
    }

    @And("drag and drop")
    public void dragAndDrop() {
        //dragDrop(getDriver(), page.dragObject, 620, 950);
        dragDropWithCoordinates(getDriver(), 205,557, 620, 950);
    }



}
