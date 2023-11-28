package org.example.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.baseDriver.PageDriver;
import org.example.utilitis.GetScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

public class CheckoutPage {

    ExtentTest test;

    public CheckoutPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='billing_phone']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='billing_alternative_phone']")
    WebElement emergencyNumber;

    @FindBy(xpath = "//input[@id='billing_email']")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"select2-billing_state-container\"]")
    WebElement district;

    @FindBy(xpath = "//select[@id='billing_area']")
    WebElement area;

    @FindBy(xpath = "//textarea[@id='billing_address_1']")
    WebElement address;

    @FindBy(xpath = "//textarea[@id='order_comments']")
    WebElement another;


    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        @SuppressWarnings("unused")
        String screenShotPath = GetScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        Assert.assertTrue(name.isDisplayed());
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

    public void CheckOutPage() throws IOException {
        Actions actions = new Actions(PageDriver.getCurrentDriver());
        try {
            test.info("Click name");
            if (name.isDisplayed()) {
                actions.moveToElement(name);
                name.sendKeys("asik billah");
                Thread.sleep(4000);
                passCaseWithSC("name clicked","name click pass");

                try {
                    test.info("Click phoneNumber");
                    if (phoneNumber.isDisplayed()) {
                        actions.moveToElement(phoneNumber);
                        phoneNumber.sendKeys("01738152959");
                        Thread.sleep(4000);
                        passCaseWithSC("phoneNumber clicked","phonenumber click pass");

                        try {
                            test.info("Click emergencyPhone");
                            if (emergencyNumber.isDisplayed()) {
                                actions.moveToElement(emergencyNumber);
                                emergencyNumber.sendKeys("01517862311");
                                Thread.sleep(4000);
                                passCaseWithSC("emergencyPhone clicked","emergencyPhone click pass");

                                try {
                                    test.info("Click email");
                                    if (email.isDisplayed()) {
                                    	actions.moveToElement(email);
                                        email.sendKeys("asikbd99@gmail.com");
                                        Thread.sleep(4000);
                                        passCaseWithSC("email clicked","email click pass");
                                        
                                                try {
                                                    test.info("Click area");
                                                    if (area.isDisplayed()) {
                                                    	Select select1 = new Select(area);
                                                        area.click();
                                                        Thread.sleep(3000);
                                                        select1.selectByIndex(3);
                                                        Thread.sleep(4000);
                                                        passCaseWithSC("area clicked","area click pass");

                                                        try {
                                                            test.info("Click Address");
                                                            if (address.isDisplayed()) {
                                                                actions.moveToElement(address);
                                                                address.sendKeys("200/1 A গাইবান্ধা সদর");
                                                                Thread.sleep(4000);
                                                                passCaseWithSC("address clicked","address click pass");

                                                                try {
                                                                    test.info("Click another");
                                                                    if (another.isDisplayed()) {
                                                                        actions.moveToElement(another);
                                                                        another.sendKeys("গাইবান্ধা সদর gaibandha");
                                                                        Thread.sleep(4000);
                                                                        passCaseWithSC("another clicked","another click pass");

                                                                    }

                                                                } catch (Exception e) {
                                                                    failCase("another was not locatable", "anotherfail");
                                                                }

                                                            }

                                                        } catch (Exception e) {
                                                            failCase("address was not locatable", "addressfail");
                                                        }
                                                    }

                                                } catch (Exception e) {
                                                    failCase("area was not locatable", "areafail");
                                                }
                                            }


                                } catch (Exception e) {
                                    failCase("email was not locatable", "emailfail");
                                }
                            }

                        } catch (Exception e) {
                            failCase("emergencyPhone was not locatable", "emergencyPhone fail");
                        }

                    }

                } catch (Exception e) {
                    failCase("Phone was not locatable", "phonefail");
                }

            }

        } catch (Exception e) {
            failCase("name was not locatable", "namefail");
        }


    }



}
