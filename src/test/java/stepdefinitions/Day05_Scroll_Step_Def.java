package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.Day05_Scroll_Page;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.*;

public class Day05_Scroll_Step_Def {


    Day05_Scroll_Page page= new Day05_Scroll_Page();

    @And("click on splitting touches")
    public void clickOnSplittingTouches() {
        scrollDown(getDriver(), page.page, 1.0);
        ReusableMethods.wait(2);
        page.splittingTouches.click();


    }

    @And("scroll through {int} elements")
    public void scrollThroughElements(int arg0) {

        scrollDown(getDriver(), page.elements.get(0), arg0);



    }


    @And("make a page scroll down")
    public void makeAPageScrollDown() {
        scrollDown(getDriver(), page.page, 1.0);

    }

    @And("make a page scroll up")
    public void makeAPageScrollUp() {
        ReusableMethods.wait(2);
        scrollUp(getDriver(), page.page, 0.50);
        ReusableMethods.wait(2);
        scrollUp(getDriver(), page.page, 0.50);
    }


    @And("scroll end of the page")
    public void scrollEndOfThePage() {
        //Tam ekran boyutunda scroll end
       // scrollToTheDownOfThePage(getDriver(),page.kitapYurduPage,1.0 );

        //Bir element boyutunda scroll end
        scrollToTheDownOfThePage(getDriver(),page.kitapYurduReklam.get(1),1.0 );



    }




}
