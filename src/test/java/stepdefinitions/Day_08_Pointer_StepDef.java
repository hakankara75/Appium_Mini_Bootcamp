package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pages.Day_08_Pointer_Page;

import java.time.Duration;
import java.util.Collections;

import static utilities.Driver.getDriver;

public class Day_08_Pointer_StepDef {


    Day_08_Pointer_Page page=new Day_08_Pointer_Page();

    //1- PointerInput objesi olustururum
    PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");



    @And("tap on the second book")
    public void tapOnTheSecondBook() {
        //2- Sequence obje olusturulur
        Sequence sequence=new Sequence(finger,1)

    //3- addAction ile ve sonrasinda  sequence objesine yaptirilacak isler tanimlanir
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),452,1475))

    //4-parmak burada mause sol butonu gibi kullanilacak
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
    //5-element uzerine dokunan parmagin orada kalma suresi verilir
                .addAction(new Pause(finger,Duration.ofMillis(300)))
    //6-paramagi dokundugumuz yerden kaldiririz
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    //7- sequence objesine yuklenen gorev gerceklestirme emri verilir
        getDriver().perform(Collections.singletonList(sequence));
    }
}
