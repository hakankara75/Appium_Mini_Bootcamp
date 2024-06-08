package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pages.Day_08_Pointer_Page;
import utilities.ReusableMethods;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import static utilities.Driver.getDriver;

public class Day_08_Pointer_StepDef {


    Day_08_Pointer_Page page=new Day_08_Pointer_Page();

    //1- PointerInput objesi olustururum
    PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
    PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH, "finger1");



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

    @And("double tap on first book in ilgi gorenler")
    public void doubleTapOnFirstBookInIlgiGorenler() {
        //2- Sequence obje olusturulur
        Sequence sequence=new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),170,1490 ))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

                .addAction(finger.createPointerMove(Duration.ofMillis(10), PointerInput.Origin.viewport(),173,1493))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(sequence));



    }

    @And("long click on sepetim")
    public void longClickOnSepetim() {

        Sequence sequence=new Sequence(finger, 1)
                .addAction(finger. createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),973,2183))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(1000)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(sequence));

    }

    @And("swipe to left first book of ilgi gorenler")
    public void swipeToLeftFirstBookOfIlgiGorenler() {
        Sequence sequence=new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),1040,1511))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),40, 1511))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(sequence));

    }

    @And("fling left first book of ilgi gorenler")
    public void flingLeftFirstBookOfIlgiGorenler() {
        Sequence sequence=new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),1040,1516))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(20)))
                .addAction(finger.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(),50,1517))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(sequence));

    }

    @And("drag and drop with pointer")
    public void dragAndDropWithPointer() {
        Sequence sequence =new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),205,566))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(4000),PointerInput.Origin.viewport(),616,909))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(sequence));




    }

    @Given("go to files")
    public void goToFiles() {

    }

    @And("click on first screen")
    public void clickOnFirstScreen() {
        page.images.get(0).click();
    }

    @And("pointer zoom in")
    public void pointerZoomIn() {
        Sequence sequence= new Sequence(finger, 1);
        Sequence sequence1= new Sequence(finger1, 2);

        //1. parmak için koordinat ve hareket yönü tanımlayacağız (merkezden sol tarafa hareket etti)
        sequence
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),548,1155))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(), 18,1155))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        //2. parmak için koordinat ve hareket yönü tanımlayacağız (merkezden sağ tarafa hareket etti)
        sequence1
                .addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),560,1155))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),1050,1155))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Arrays.asList(sequence,sequence1));


        ReusableMethods.wait(2);

    }

    @And("pointer zoom out")
    public void pointerZoomOut() {
        Sequence sequence= new Sequence(finger, 1);
        Sequence sequence1= new Sequence(finger1, 2);

        //1. parmak için koordinat ve hareket yönü tanımlayacağız (merkezden sol tarafa hareket etti)
        sequence
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),18,1155))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(), 548,1155))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        //2. parmak için koordinat ve hareket yönü tanımlayacağız (merkezden sağ tarafa hareket etti)
        sequence1
                .addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),1050,1155))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(2000),PointerInput.Origin.viewport(),560,1155))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Arrays.asList(sequence,sequence1));



    }


}