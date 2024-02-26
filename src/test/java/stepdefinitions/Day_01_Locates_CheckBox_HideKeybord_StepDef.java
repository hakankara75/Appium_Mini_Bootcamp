package test.java.stepdefinitions;


import io.cucumber.java.en.*;
import pages.Day_01_Locates_CheckBox_HideKeybord_Page;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class Day_01_Locates_CheckBox_HideKeybord_StepDef {
    Day_01_Locates_CheckBox_HideKeybord_Page page=new Day_01_Locates_CheckBox_HideKeybord_Page();

    @When("click on api demos")
    public void click_on_api_demos() {
        page.apiDemos.get(1).click();
    }

    @Then("verify api demos text appears")
    public void verify_api_demos_text_appears() {
        String expectedText ="API Demos";
        String actualText= page.apiDemosText.getText();
        assertEquals(expectedText, actualText);
    }
    @Given("Go to api demos apk")
    public void go_to_api_demos_apk() {


    }
    @Then("click on accessibility")
    public void click_on_accessibility() {
        page.accessibilityElements.get(0).click();
    }


    @Then("click on accessibility node querying")
    public void click_on_accessibility_node_querying() {
        page.accessibilityNodeQuerying.get(0).click();
    }


    @Then("verify take out trash checkbox check")
    public void verify_take_out_trash_checkbox_check() {
        ReusableMethods.waitToBeVisible(page.checkBoxes.get(0), Duration.ofSeconds(1));
        System.out.println("apiDemosScreenPage.takeOutTrash.isSelected() = " + page.checkBoxes.get(0).isSelected());
        assertTrue(page.checkBoxes.get(0).isSelected());
    }

    @Then("verify conquer world checkbox uncheck")
    public void verify_conquer_world_checkbox_uncheck() {
        assertFalse(page.conquerWorld.isSelected());
    }

    @Then("click conquer world checkbox")
    public void click_conquer_world_checkbox() {
        page.conquerWorld.click();
    }

    @Then("verify conquer world checkbox check")
    public void verify_conquer_world_checkbox_check() {
        assertTrue(page.conquerWorld.isSelected());
    }


}
