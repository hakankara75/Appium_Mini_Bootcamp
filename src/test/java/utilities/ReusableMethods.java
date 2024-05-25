package utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import static utilities.Driver.getDriver;


public class ReusableMethods {
  /**
   * bu metot ile bir element zoom yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param element yerine zoom yapilacak element locate verilir
   * @param percent yerine zoom orani girilir. 0 ile 1 arasi bir deger double olarak verilir
   * @param speed yerine int cinsinden hiz icin deger verilir
   */

  public static void pinchOpen(AndroidDriver driver, WebElement element, double percent,int speed ){

    driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "percent", percent,
            "speed",speed
    ));
  }

  /**
   * bu metot ile bir element zoomu kapatilir yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param element yerine zoomu kapatilacak element locate verilir
   * @param percent yerine zoom out orani girilir. 0 ile 1 arasi bir deger double olarak verilir
   * @param speed yerine int cinsinden hiz icin deger verilir
   */
  public static void pinchClose(AndroidDriver driver, WebElement element, double percent,int speed ){

    driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "percent", percent,
            "speed",speed
    ));
  }
  /**
   * Bu metot ile sayfada hızlı bir şekilde kaydırma / fırlatma yapılır.
   * Ekran fırlatılarak kaydırılır.
   * @param driver yerin Android driver verilir
   * @param element yerine locate verilir
   * @param direction yerine up, down, left ve right verilir
   * @param speed yerine int cinsinden değer verilir.
   */
  public static void fling(AndroidDriver driver,WebElement element,String direction, int speed){
    driver.executeScript("mobile: flingGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", direction,
            "speed", speed
    ));
  }


  /**
   * Bu metot ile verilen yön istikametinde ve verilen ölçü büyüklüğünde swipe(kaydırma) yapılır
   * @param driver yerine Android driver
   * @param x yerine elementin x değeri
   * @param y yerine elementin y değeri
   * @param w yerine elementin width değeri
   * @param h yerine elementin heigght değeri
   * @param direction yerine direction
   * @param percentage yerine double olarak 0 ile 1 arası bir değer
   */
  public static void swipeWithCoordinate(AndroidDriver driver, int x, int y, int w, int h, String direction, int percentage, int speed){
    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
            "left", x, "top", y, "width", w, "height", h,
            "direction", direction,
            "percent", percentage,
            "speed", speed
    ));
  }

  /**
   * Bu metot ile koordinatları verilen element büyüklüğünce scroll yapılır
   * @param driver yerine Android driver
   * @param left yerine x
   * @param top top yerine y
   * @param width width yerine genişlik
   * @param height yerine yükseklik
   * @param x yerine kaydırma büyüklüğü. 1,2,3 gibi int değerler olabilir
   * @param speed yerine hız değeri. 500 veya 1500 gibi olabilir.
   */

  public static void scrollWithCoordinates(AndroidDriver driver, int left, int top, int width, int height,String direction, int x, int speed){
    driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
            "left", left, "top", top, "width", width, "height", height,
            "direction", direction,
            "percent", x,
            "speed", speed
    ));
  }
  /**
   * bu metot ile text degeri verilen elemente kadar sayfa kaydirilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param text yerine elementin text degeri verilir
   */
  public  static void scrollToElementWithText(AndroidDriver driver,String text){
    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));

  }

  /**
   * bu metot ile sayfanin en ustune kadar scroll yapilir
   * @param driver yerine AndroidDriver objesi verilir
   *@param element yerine ekranda kaydirilacak olcu olacak element locate verilir
   * @param x yerine scroll yapilacak olcu verilir. 1.0 tam ekran, 0.50 yarim ekran vb.
   */
  public static void scrollToTheTopOfThePage(AndroidDriver driver, WebElement element, double x){
    boolean canScrollMore=true;
    while(canScrollMore){
      canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
              "elementId", ((RemoteWebElement) element).getId(),
              "direction", "up",
              "percent",x,
              "speed", 2000
      ));
    }
  }


  /**
   * bu metot ile sayfanin en altina kadar scroll yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param x yerine scroll yapilacak olcu verilir. 1.0 tam ekran, 0.50 yarim ekran vb.
   */
  public static void scrollToTheDownOfThePage(AndroidDriver driver, WebElement element, double x){
    boolean canScrollMore=true;
    while (canScrollMore){
      canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
              "elementId", ((RemoteWebElement) element).getId(),
              "direction", "down",
              "percent", x,
              "speed", 1500
      ));
    }

  }

  /**
   * Bu metot ile locate verilen elemente ekran değeri verilerek scroll yapılır.
   * @param driver Android driver verilir
   * @param element yerine tam sayfanın locate verilir
   * @param x yerine ekran boyutu 1.0 veya 0.50 gibi double değerler verilir
   */
  public static void scrollDown(AndroidDriver driver, WebElement element, double x){
    driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", "down",
            "percent", x,
            "speed", 1500
    ));
  }

  /**
   * bu metot ile sayfada yukari dogru scroll yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param element yerine ekranın tam olarak secildigi halinin id turunden locate'i verilir
   * @param x yerine scroll yapilacak olcu verilir. 1.0 tam ekran, 0.50 yarim ekran vb.
   */
  public static void scrollUp(AndroidDriver driver, WebElement element, double x){
    driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", "up",
            "percent", x,
            "speed", 1500
    ));
  }

  /**
   * Bu metot ile locate verilen elementin boyutunca ve verilen yön doğrultusunda ekran scroll yaptırılır
   * @param driver  Android driver verilir
   * @param element yerine scroll yapılacak element locate verilir
   * @param direction scroll yapılacak yön verilir. left, down gibi
   */
  public static void scrollDownElementWithDirection(AndroidDriver driver, WebElement element,String direction, double x){
    driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction",direction ,
            "percent", x,
            "speed", 500
    ));
  }

  /**
   * Bu metot ile locate verilen element verilen koordinata drag drop yapılır.
   * @param driver Driver classtaki driver verilir
   * @param element yerine sürüklenecek elementin locate verilir
   * @param x yerine elementin bırakılacağı koordinat verilir
   * @param y yerine elementin bırakılacağı koordinat verilir
   */
  public static void dragDrop(AndroidDriver driver,WebElement element,int x, int y ){
    driver.executeScript("mobile: dragGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "endX", x,
            "endY", y,
            "speed",500
    ));
  }

  /**
   * Bu metot ile bir element bir koordinat noktasından bir diğerine dragdrop yapılır
   * @param driver Driver classtaki driver verilir
   * @param startX yerine sürüklenecek elementin başlangıç koordinatı verilir
   * @param startY yerine sürüklenecek elementin başlangıç koordinatı verilir
   * @param x yerine sürüklenecek elementin bitis koordinatı verilir
   * @param y yerine sürüklenecek elementin bitis koordinatı verilir
   */
  public static void dragDropWithCoordinates(AndroidDriver driver,int startX, int startY,int x, int y ){
    driver.executeScript("mobile: dragGesture", ImmutableMap.of(
            "startX", startX,
            "startY", startY,
            "endX", x,
            "endY", y,
            "speed",500
    ));
  }

  /**
   * bu metot ile locate verilen element üzerine long click yapılır
   * @param driver yerine Driver classtaki driver verilir
   * @param element yerine locate verilir
   * @param duration yerine int cinsinden saniye verilir. Element üzerinde kaç saniye bekleneceği bu şekilde belirlenir
   */
  public static void longClick(AndroidDriver driver, WebElement element, int duration){
    driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "duration", duration*1000
    ));
  }

  public static void longClickWithCoordinates(AndroidDriver driver, int x, int y, int duration){
    driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
           "x", x,
            "y",y,
            "duration", duration*1000
    ));
  }

  /**
   * Bu metot ile elemente tek bir click yapılır
   * @param driver yerine Android driver verilir
   * @param element yerine tiklanacak elementin locate girilir
   */
  public static void clickGesture(AndroidDriver driver, WebElement element){
    driver.executeScript("mobile: clickGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId()
    ));
  }

  /**
   * bu metot ile bir elemente koordinat vererek tek bir click yapilir
   * @param driver yerine AndroidDriver verilir
   * @param x elementin koordinattaki x degerili verilir
   * @param y elementin koordinattaki y degerili verilir
   */
  public static void clickGestureWithCoordinates(AndroidDriver driver, int x, int y){
    driver.executeScript("mobile: clickGesture", ImmutableMap.of(
            "x",x,
            "y",y
    ));
  }

  /**
   * bu metot ile element uzerine double click yapilir
   * @param driver yerine AndridDriver verilecek
   * @param element yerine uzerine double click yapilacak elementin locate verilecek
   */
  public static void doubleClick(AndroidDriver driver, WebElement element){
    driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId()
    ));
  }

  /** bu metot ile bir element uzerine koordinat ile double click yapilir
   * @param driver yerine AndroidDriver verilir
   * @param x yerine elementin koordinattaki x degeri verilir
   * @param y yerine elementin koordinattaki y degeri verilir
   */
  public static void doubleClickWithCoordinates(AndroidDriver driver, int x, int y){
    driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
            "x", x,
            "y",y
    ));
  }

  /**
   * Element gorunur olmadigi surece ve sayfa sonuna gelinmedigi surece scroll down yapma metodu
   * @param element yerine android element locati verilmeli
   */
  public static void scrollForMobile(WebElement element) throws MalformedURLException {
    String previousPageSource="";
    while(isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)){
      previousPageSource=getDriver().getPageSource();
      performScroll();

    }
  }

  /**
   * elementi listin icine alıp, listin boyutunu olcer. list bos ise true dondurecek.scrollForMobile() ile kullanilir
   * @param element element locate yazilmali
   * @return true yada false doner
   */
  private static boolean isElementNotEnabled(WebElement element) throws MalformedURLException {
    List<WebElement> elements=getDriver().findElements((By) element);
    boolean enabled;
    if (elements.size() <1) enabled = true;
    else enabled = false;
    return enabled;
  }

  /**
   * bir onceki sayfa pageSource ile simdiki aynı mı diye kontrol eder
   * @param previousPageSource
   * @return
   */
  private static boolean isNotEndOfPage(String previousPageSource) throws MalformedURLException {
    return ! previousPageSource.equals(getDriver().getPageSource());
  }
  public static void performScroll() throws MalformedURLException {
    Dimension size= getDriver().manage().window().getSize();
    int startX= size.getWidth()/2;
    int endX= size.getWidth()/2;
    int startY= size.getHeight()/2;
    int endY= (int)(size.getWidth()*0.25);
    performScrollUsingSequence(startX, startY, endX, endY);
  }
  private static void performScrollUsingSequence(int startX, int startY, int endX, int endY) throws MalformedURLException {
    PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
    Sequence sequence=new Sequence(finger,0)
            .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    ((AppiumDriver)(getDriver())).perform(Collections.singletonList(sequence));
  }

  /**
   * bu metot ile aranan bir texti iceren elemente scroll yapilir
   * @param textFromOutSide aranan text degeridir
   */
  public static void scrollTo(String textFromOutSide) throws MalformedURLException {
    AppiumBy.ByAndroidUIAutomator permissionElement = new AppiumBy.ByAndroidUIAutomator("new UiScrollable"+
            "(new UiSelector().scrollable(true).instance(0)."+
            "scrollIntoView(new UiSelector()"+".textMatches(\""+textFromOutSide+"\").instance(0)");
    getDriver().findElement(permissionElement);
  }

  /**
   * bu metot UiSelector cinsinden locate dondurur
   * @param text locate alinacak elementin text attribute icinde yazan metindir
   * @return
   */
  public static By locateElementByText(String text){
    return AppiumBy.androidUIAutomator("new UiSelector().text(\""+text+"\")");
  }
  public static void tapOnElementWithText(String text) {
    List<WebElement> mobileElementList = getDriver().findElements(By.className("android.widget.TextView"));
    for (WebElement page: mobileElementList) {
      if (page.getText().equalsIgnoreCase(text)){
        page.click();
      }else{
        scrollWithUiScrollableAndTapOn(getDriver(),text);
      }
      break;
    }
  }

  public static boolean isElementPresent(String text) {
    boolean elementFound = false;
    List<WebElement> mobileElementList = getDriver().findElements(By.xpath("//android.widget.TextView[@text='" + text + "']"));
    for (WebElement el : mobileElementList) {
      if (el.getText().equals(text)) {
        waitToBeVisible(el, Duration.ofSeconds(10));
        if (el.isDisplayed()) {
          elementFound = true;
        }
      }
    }
    return elementFound;
  }

  public static void wait(int second) {
    try {
      Thread.sleep(second * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void tapOn(WebElement element) {
    waitToBeClickable(element, Duration.ofSeconds(10));
    element.click();
  }



  public static void enterText(WebElement element, String text) {
    waitToBeClickable(element, Duration.ofSeconds(10));
    element.sendKeys(text);
  }

  public static void enterText(WebElement element, String text, boolean needClear) {
    waitToBeClickable(element, Duration.ofSeconds(10));
    if (needClear) {
      element.clear();
    }
    element.sendKeys(text);
  }

  public static boolean isElementPresent(WebElement webElement) {
    boolean elementFound = false;
    waitToBeVisible(webElement, Duration.ofSeconds(10));
    if (webElement.isDisplayed()) {
      elementFound = true;
    }
    return elementFound;
  }

  /**
   * Element gorunene kadar kodlari bekletir
   * @param element beklenilecek elementin locate
   * @param timeout ne kadar sure beklenilecegi int olarak verilir
   */
  public static void waitToBeVisible(WebElement element, Duration timeout) {
    WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitToBeClickable(WebElement element, Duration timeout) {
    WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  /**
   * bu metot ile scrollable özelliği olan elementlere scroll yapılıp ardından tap yapilir
   * @param elementText elementin text value'su verilir
   * @param driver yerine AndroidDriver verilir
   */
  public static void scrollWithUiScrollableAndTapOn( AndroidDriver driver, String elementText) {
    driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))"));

    tapOn(driver.findElement(By.xpath("//android.widget.TextView[@text='" + elementText + "']")));
  }



  public static void backToPreScreen(){
    getDriver().navigate().back();
  }


  public static void getScreenshot() throws IOException {
    //after verification take screenshot
    //I use this code to take a screenshot when needed
    // naming the screenshot with the current date to avoid duplication

    String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    // TakesScreenshot is an interface of selenium that takes the screenshot
    TakesScreenshot ts = (TakesScreenshot) getDriver();
    File source = ts.getScreenshotAs(OutputType.FILE);

    // full path to the screenshot location
    String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + date + ".png";
    File finalDestination = new File(target);

    // save the screenshot to the path given
    FileUtils.copyFile(source, finalDestination);
  }
  public static void validateCompabilitiyOfSubTitleWithTheTitle(String subTitle, String title) throws IOException {
    //Title alanı birden fazla mainword içeriyorsa  ayırıyoruz
    String[] titleElements = title.split(" ");
    for (int i = 0; i < titleElements.length; i++) {
      System.out.println("subtitle :" + subTitle);
      System.out.println("i :" + titleElements[i]);
      System.out.println("i+1 :" + titleElements[i + 1]);
      if (subTitle.contains(titleElements[i])) {
        Assert.assertTrue(subTitle.contains(titleElements[i]));
        System.out.println("sub title :" + subTitle + " başlık " + titleElements[i] + " kapsıyor");
        break;
      } else if (subTitle.contains(titleElements[i + 1])) {
        Assert.assertTrue(subTitle.contains(titleElements[i + 1]));
        System.out.println("sub title :" + subTitle + " başlık " + titleElements[i + 1] + " kapsıyor");
        break;
      } else System.out.println("subtitle :" + subTitle + " başlık değerlerini KAPSAMIYOR");
      getScreenshot();
      Assert.assertTrue(false);
    }
  }





  /**
   * bu metot ile koordinat vererek asagi dogru scroll yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param left yerine x koordianati verilir 100 vb.
   * @param top yerine y koordianati verilir 100 vb.
   * @param width yerine genislik verilir 100 vb.
   * @param height yerine yukseklik verilir 100 vb.
   * @param x yerine scroll yapilacak olcu verilir. 1.0 tam ekran, 0.50 yarim ekran vb.
   */

  public static void scrollDownWithCoordinates(AndroidDriver driver, int left, int top, int width, int height, double x){

    driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
            "left", left, "top", top, "width", width, "height", height,
            "direction", "down",
            "percent",x,
            "speed", 1000
    ));
  }


  /**
   * bu metot ile sayfanin en ustune kadar scroll yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param left yerine x koordianati verilir 100 vb.
   * @param top yerine y koordianati verilir 100 vb.
   * @param width yerine genislik verilir 100 vb.
   * @param height yerine yukseklik verilir 100 vb.
   * @param x yerine scroll yapilacak olcu verilir. 1.0 tam ekran, 0.50 yarim ekran vb.
   */
  public static void scrollToTheTopOfThePageWithCoordinates(AndroidDriver driver, int left, int top, int width, int height, double x){

    boolean canScrollMore =true;
    while (canScrollMore){
      canScrollMore= (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
              "left", left, "top", top, "width", width, "height", height,
              "direction", "up",
              "percent", x,
              "speed", 1500
      ));
    }
  }



  public static void scrollToElementWithDirection(AndroidDriver driver,WebElement element, String direction){
    driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", direction,
            "percent",1.0,
            "speed", 500
    ));
  }




  /**
   * bu metot ile yön verilerek istenen tarafa (left, rigtht, up, down) kaydirma yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param element yerine elementin locate verilir
   * @param direction yerine (left, rigtht, up, down) yonlerinden birisi text olarak verilir
   * @param percent yerine 0 ile 1 arasi bir deger verilir. Bu deger kaydirma oranini belirler.
   * @param speed  yerine int cinsinden sayi girilir. Bu deger kaydirmanin ivmesini belirler. Ne kadar hizli olmasini istersek sayi o kadar buyuk olmali (1000 veya 10000 gibi).
   */
  public static void swipe(AndroidDriver driver, WebElement element, String direction, double percent, int speed){
    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", direction,
            "percent", percent,
            "speed", speed
    ));
  }


  /**
   * bu metot ile coordinat verilerek istenen yone (left, rigtht, up, down) kaydirma yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param x yerine x koordinat degeri verilir
   * @param y yerine y koordinat degeri verilir
   * @param w yerine genislik verilir
   * @param h yerine yukseklik verilir
   * @param direction yerine (left, rigtht, up, down) yonlerinden birisi text olarak verilir
   * @param percent  yerine 0 ile 1 arasi bir deger verilir. Bu deger kaydirma oranini belirler.
   * @param speed  yerine int cinsinden sayi girilir. Bu deger kaydirmanin ivmesini belirler. Ne kadar hizli olmasini istersek sayi o kadar buyuk olmali (1000 veya 10000 gibi).
   */
  public static void swipeWithCoordinate(AndroidDriver driver,  int x, int y, int w, int h, String direction, double percent, int speed){
    driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
            "left", x, "top", y, "width", w, "height", h,
            "direction", direction,
            "percent", percent,
            "speed", speed
    ));
  }

  /**
   * bu metot ile element verilerek istenen asagi dogru firlatma yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param element yerine elementin locate verilir
   * @param speed  yerine int cinsinden sayi girilir. Bu deger kaydirmanin ivmesini belirler. Ne kadar hizli olmasini istersek sayi o kadar buyuk olmali (1000 veya 10000 gibi).
   */
  public static void fling(AndroidDriver driver, WebElement element, int speed){
    driver.executeScript("mobile: flingGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", "down",
            "speed", speed
    ));
  }


  /**
   * bu metot ile coordinat verilerek istenen asagi dogru firlatma yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param x yerine x koordinat degeri verilir
   * @param y yerine y koordinat degeri verilir
   * @param w yerine genislik verilir
   * @param h yerine yukseklik verilir
   * @param speed  yerine int cinsinden sayi girilir. Bu deger kaydirmanin ivmesini belirler. Ne kadar hizli olmasini istersek sayi o kadar buyuk olmali (1000 veya 10000 gibi).
   */
  public static void flingWithCoordinate(AndroidDriver driver,  int x, int y, int w, int h, int speed){
    driver.executeScript("mobile: flingGesture", ImmutableMap.of(
            "left", x, "top", y, "width", w, "height", h,
            "direction", "down",
            "speed", speed
    ));
  }



  /**
   * bu metot ile bir element koordinate verilerek zoom yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param x yerine x koordinat degeri verilir
   * @param y yerine y koordinat degeri verilir
   * @param w yerine genislik verilir
   * @param h yerine yukseklik verilir
   * @param percent yerine zoom orani girilir. 0 ile 1 arasi bir deger double olarak verilir
   * @param speed yerine int cinsinden hiz icin deger verilir
   */
  public static void pinchOpenWithCoordinate(AndroidDriver driver, int x, int y, int w, int h, double percent, int speed){
     driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
             "left", x, "top", y, "width", w, "height", h,
            "percent", percent,
             "speed", speed
    ));
  }



  /**
   * bu metot ile bir element koordinate verilerek zoom yapilir
   * @param driver yerine AndroidDriver objesi verilir
   * @param x yerine x koordinat degeri verilir
   * @param y yerine y koordinat degeri verilir
   * @param w yerine genislik verilir
   * @param h yerine yukseklik verilir
   * @param percent yerine zoom orani girilir. 0 ile 1 arasi bir deger double olarak verilir
   * @param speed yerine int cinsinden hiz icin deger verilir
   */
  public static void pincClosehWithCoordinate(AndroidDriver driver, int x, int y, int w, int h, double percent, int speed){
    driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
            "left", x, "top", y, "width", w, "height", h,
            "percent", percent,
            "speed", speed
    ));
  }

  /**
   * bu metot ile PointerInput ile tap yapilir
   * @param driver AppiumDriver verilir
   * @param x tap yapilacak elementin x koordinati girilir
   * @param y tap yapilacak elementin y koordinati girilir
   */
  public static void pointerTap(AppiumDriver driver, int x, int y){
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence sequence = new Sequence(finger, 1)
            // 3- sequence objesine addAction() eklenerek yapilacak isler belirlenir
            // Parmak, ekran üzerindeki tap yapılacak koordinata yazilir.
            .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y))
            // Parmak ile (farenin sol tuşuna basar gibi) ekranda belirlediğimiz koordinata gidilir.
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            // Ekranda parmagin basili kalacagi sureyi veririz
            .addAction(new Pause(finger, Duration.ofMillis(300)))
            // Parmagimizi ekranda bastigimiz koordinattan kaldiririz
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    //4- bitirme islemi
    driver.perform(Collections.singletonList(sequence));
  }
  /**
   * bu metot ile PointerInput ile doubltap yapilir
   * @param driver AppiumDriver verilir
   * @param x tap yapilacak elementin x koordinati girilir
   * @param y tap yapilacak elementin y koordinati girilir
   * @param a tap yapilacak elementin x koordinatinin az farkli sekli girilir
   * @param b tap yapilacak elementin y koordinatinin az farkli sekli girilir
   */
  public static void pointerDoubleTap(AppiumDriver driver, int x, int y, int a, int b){
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    Sequence sequence = new Sequence(finger, 1)

            .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger, Duration.ofMillis(300)))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))


            .addAction(finger.createPointerMove(Duration.ofMillis(10), PointerInput.Origin.viewport(), a, b)) //hata alinmamasi icin yukaridakinden az farkli koordinat girildi
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger, Duration.ofMillis(300)))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
  }

  /**
   * Bu metot ile elemente long press yapilir
   * @param driver AppiumDriver verilir
   * @param x long press yapilacak elementin x koordinati girilir
   * @param y long press yapilacak elementin y koordinati girilir
   */
  public static void longPress(AppiumDriver driver, int x, int y){
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    Sequence sequence = new Sequence(finger, 1)
            .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger, Duration.ofMillis(1000)))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
  }

  /**
   * Bu metot ile toast message(kaybolan mesaj)'in ustunde yazan mesaj alinir ve string olarak doner
   * @return string olarak doner
   */
  public static String getToastMessage() {
    String toastMessage= getDriver().findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
    return toastMessage;
  }

}