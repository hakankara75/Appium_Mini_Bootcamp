package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Day_01_Locates_CheckBox_HideKeybord_Page;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.*;

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


    @Given("go to kitapyurdu apk")
    public void goToKitapyurduApk() {
    }

    @When("click on ilgi gorenler")
    public void clickOnIlgiGorenler() {

        page.ilgiGorenler.get(0).click();


    }

    @Given("go to api demos apk")
    public void goToApiDemosApk() {
    }

    @When("click on accessibility link")
    public void clickOnAccessibilityLink() {
        page.accessibility.click();

    }

    @Then("assert accesibility page open")
    public void assertAccesibilityPageOpen() {

        assertTrue(page.nodequerying.isDisplayed());

    }

    @Given("go to n{int} apk")
    public void goToNApk(int arg0) {
    }

    @Then("assert n{int} page")
    public void assertNPage(int arg0) {
        assertTrue(page.n11MainPage.get(1).isDisplayed());
    }

    @And("click on n{int} searchbox")
    public void clickOnNSearchbox(int arg0) {
        page.searchBox.click();

    }

    @And("send {string} to n{int} searchbox")
    public void sendToNSearchbox(String arg0, int arg1) {
        page.searchBox2.sendKeys(arg0);
    }

    @And("select {string}")
    public void select(String arg0) {
    page.erkekKazak.click();
    }

    @And("click filtrele")
    public void clickFiltrele() {
        page.filtrele.click();

    }

    @And("click beden")
    public void clickBeden() {
        page.beden.click();

    }

    @When("click M checkbox")
    public void clickMCheckbox() {
        page.m.get(2).click();
        ReusableMethods.wait(2);
    }

    @Then("assert M checkbox checked")
    public void assertMCheckboxChecked() {
        System.out.println("page.m.get(2).isSelected() = " + page.m.get(2).isSelected());
        String actualCheck=page.m.get(2).getAttribute("checked");
        System.out.println("page.m.get(2).getAttribute(\"checked\") = " + page.m.get(2).getAttribute("checked"));
        String expectedCheck="true";
        assertEquals(expectedCheck,actualCheck);
    }
}
