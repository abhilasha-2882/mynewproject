package com.qa.w3.ExtentReportListner;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.util.Date;
import java.util.List;

public class ExtentReporterListner implements IReporter {

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        ExtentSparkReporter spark = new ExtentSparkReporter(outputDirectory + File.separator + "Extent.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        for (ISuite suite : suites) {
            for (ISuiteResult result : suite.getResults().values()) {
                ITestContext context = result.getTestContext();

                // Log passed tests
                for (ITestResult tr : context.getPassedTests().getAllResults()) {
                    ExtentTest test = extent.createTest(tr.getMethod().getMethodName())
                                            .assignCategory(context.getName());
                    test.pass("Test passed");
                    test.info("Start Time: " + new Date(tr.getStartMillis()));
                    test.info("End Time: " + new Date(tr.getEndMillis()));
                }

                // Log failed tests
                for (ITestResult tr : context.getFailedTests().getAllResults()) {
                    ExtentTest test = extent.createTest(tr.getMethod().getMethodName())
                                            .assignCategory(context.getName());
                    test.fail("Test failed");
                    test.fail(tr.getThrowable()); // clickable stack trace
                    test.info("Start Time: " + new Date(tr.getStartMillis()));
                    test.info("End Time: " + new Date(tr.getEndMillis()));
                }

                // Log skipped tests
                for (ITestResult tr : context.getSkippedTests().getAllResults()) {
                    ExtentTest test = extent.createTest(tr.getMethod().getMethodName())
                                            .assignCategory(context.getName());
                    test.skip("Test skipped");
                    test.info("Start Time: " + new Date(tr.getStartMillis()));
                    test.info("End Time: " + new Date(tr.getEndMillis()));
                }
            }
        }

        extent.flush();
    }
}