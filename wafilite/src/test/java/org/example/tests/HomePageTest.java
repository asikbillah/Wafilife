package org.example.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.baseDriver.BaseDriver;
import org.example.baseDriver.PageDriver;
import org.example.pages.HomePage;
import org.example.utilitis.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start() throws InterruptedException {
        PageDriver.getCurrentDriver().get(url);
        Thread.sleep(5000);
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>WAFILIFE HOMEPAGE</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");

    }
    @Test
    public void homeTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>HOMEPAGE Test</b></p>");
        HomePage homePage = new HomePage(childTest);
        homePage.home();
    }

    @AfterClass
    public void report(){
        report.flush();
    }
}
