package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.baseDriver.BaseDriver;
import org.example.pages.OrderPage;
import org.example.utilitis.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderPageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void start() throws InterruptedException {
        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>OrderPage</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");

    }
    @Test
    public void orderPageTest() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>OrderPage TEST</b></p>");
        OrderPage orderPage = new OrderPage(childTest);
        orderPage.rClick();

    }
    @AfterClass
    public void report(){
        report.flush();
    }

}
