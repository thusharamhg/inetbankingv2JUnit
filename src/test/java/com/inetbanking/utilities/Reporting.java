package com.inetbanking.utilities;

/*

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName); // Specify location
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Thushara De Silva");

        htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Title of report
        htmlReporter.config().setReportName("Functional Test Automation Report"); // Name of report
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

        File f = new File(screenshotPath);

        if (f.exists()) {
            try {
                logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}
*/






/*
//thush - method 2

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestWatcher {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @Override
    public void starting(Description description) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Your Name");

        htmlReporter.config().setDocumentTitle("Your Project Name");
        htmlReporter.config().setReportName("Functional Test Automation Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void succeeded(Description description) {
        logger = extent.createTest(description.getDisplayName());
        logger.log(Status.PASS, MarkupHelper.createLabel(description.getDisplayName(), ExtentColor.GREEN));
    }

    @Override
    public void failed(Throwable e, Description description) {
        logger = extent.createTest(description.getDisplayName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(description.getDisplayName(), ExtentColor.RED));
        logger.fail(e);

        // Add screenshot capturing logic if needed
    }

    public void skipped(Description description) {
        logger = extent.createTest(description.getDisplayName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(description.getDisplayName(), ExtentColor.ORANGE));
    }

    @Override
    public void finished(Description description) {
        extent.flush();
    }
}
*/



//thush - method 3
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends RunListener {
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    public static void start() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Thushara De Silva");

        htmlReporter.config().setDocumentTitle("InetBanking Test Project");
        htmlReporter.config().setReportName("Functional Test Automation Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void testStarted(Description description) {
        logger = extent.createTest(description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) {
        extent.flush();
    }

    public static void logPass(String testName) {
        logger.log(Status.PASS, MarkupHelper.createLabel(testName, ExtentColor.GREEN));
    }

    public static void logFail(String testName, Throwable t) {
        logger.log(Status.FAIL, MarkupHelper.createLabel(testName, ExtentColor.RED));
        logger.fail(t);
    }

    public static void logSkip(String testName) {
        logger.log(Status.SKIP, MarkupHelper.createLabel(testName, ExtentColor.ORANGE));
    }
}



