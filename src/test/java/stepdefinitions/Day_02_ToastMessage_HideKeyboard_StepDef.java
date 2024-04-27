package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Day_01_Locates_CheckBox_HideKeybord_Page;
import pages.Day_02_ToastMessage_HideKeyboard_Page;

import static org.junit.Assert.*;
import static utilities.Driver.getDriver;

public class Day_02_ToastMessage_HideKeyboard_StepDef {


    Day_02_ToastMessage_HideKeyboard_Page page= new Day_02_ToastMessage_HideKeyboard_Page();
    @And("click on n{int} hesabim")
    public void clickOnNHesabim(int arg0) {
        page.hesabim.get(4).click();
    }

    @And("click on n{int} hesabim giris yap")
    public void clickOnNHesabimGirisYap(int arg0) {
        page.girisYap.click();

    }

    @And("send email to n{int} email box")
    public void sendEmailToNEmailBox(int arg0) {
        page.email.sendKeys("hakanbatirhan@gmail.com");
    }

    @And("click on n{int} hesabim giris yap second")
    public void clickOnNHesabimGirisYapSecond(int arg0) {

        page.girisYapSecond.click();
    }

    @And("send to n{int} sifre box")
    public void sendToNSifreBox(int arg0) {
        page.sifre.sendKeys("123dgldsfgklsd");
        //keyboard gizleme komutu
        getDriver().hideKeyboard();

    }

    @When("click on n{int} hesabim giris yap third")
    public void clickOnNHesabimGirisYapThird(int arg0) {
        page.girisYap.click();

    }

    @Then("verify error message")
    public void verifyErrorMessage() {
        String expectedMessage= "E-posta adresi veya şifre hatalı, kontrol edebilir misin?";
        // String actualMessage=page.message.getText();   //toast message da bu locate ile texti alamiyoruz
        String actualMessage=page.message.getAttribute("name");
        System.out.println("actualMessage = " + actualMessage);
        assertEquals(expectedMessage,actualMessage);


    }


    @Given("go to blabla")
    public void goToBlabla() {
    }

    @And("send eposta")
    public void sendEposta() {
        page.epostaSifre.get(0).sendKeys("hakanbatirhan@gmail.com");

    }

    @And("send parola")
    public void sendParola() {
        page.epostaSifre.get(1).sendKeys("1342dghsdhsdgfd");

        //keybord saklama komutu
        getDriver().hideKeyboard();
    }

    @When("click on giris yap")
    public void clickOnGirisYap() {
        page.giris.click();
    }

    @Then("verify blablas error message")
    public void verifyBlablasErrorMessage() {
        String expectedMessage= "Girdiğin kullanıcı adı veya parola yanlış.";
        // String actualMessage=page.errorMessage.getText();  //toast message da bu locate ile texti alamiyoruz
        String actualMessage=page.errorMessage.getAttribute("name");
        System.out.println("actualMessage = " + actualMessage);

        assertEquals(expectedMessage,actualMessage);


    }

    @And("click on blabla giris yap first")
    public void clickOnBlablaGirisYapFirst() {
        page.girisYapFirst.click();


    }

    @And("click on eposta")
    public void clickOnEposta() {
        page.eposta.click();
    }
}
