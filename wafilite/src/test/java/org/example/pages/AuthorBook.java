package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.baseDriver.PageDriver;
import org.example.utilitis.GetScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class AuthorBook {
    ExtentTest test;

    public AuthorBook(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//a[normalize-space()='Dictionary of Idioms and Phrases']")
    WebElement bookSelect;

    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(bookSelect.isDisplayed());
        PageDriver.getCurrentDriver().quit();
    }

    public void passCase(String message){
        test.pass("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
    }

    @SuppressWarnings("unused")
    public void passCaseWithSC(String message, String scName) throws IOException {
        test.pass("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }



    public void book() throws IOException {
        Actions actions = new Actions(PageDriver.getCurrentDriver());
        try {
            test.info("book select");
            if (bookSelect.isDisplayed()) {
                actions.moveToElement(bookSelect);
                bookSelect.click();
                Thread.sleep(3000);
                passCaseWithSC("book selected", "book select successful");
            }

        } catch (Exception e) {
            failCase("bookselect was not locatable", "bookselectfail");

        }

    }
}
