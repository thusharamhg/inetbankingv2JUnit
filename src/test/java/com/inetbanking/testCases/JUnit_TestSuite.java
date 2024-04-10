package com.inetbanking.testCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.ClassRule;
import com.aventstack.extentreports.ExtentReports;
import com.inetbanking.utilities.Reporting;

import org.junit.runner.notification.RunListener;
import org.junit.runners.model.InitializationError;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TC_LoginTest_001.class,
	//TC_LoginDDT_002.class,
	TC_AddCustomerTest_003.class
})


public class JUnit_TestSuite {
	
	//thush - method 2
   //@ClassRule
   //public static Reporting reporting = new Reporting();
	
	
	//thush - method 3
    static {
        Reporting.start(); // Start the reporting
    }
    
    @After
    public static void tearDown() {
        Reporting.extent.flush(); // Flush the report
    }

}
