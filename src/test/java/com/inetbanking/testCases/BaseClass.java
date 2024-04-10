package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.junit.After;             
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.inetbanking.utilities.ReadConfig;

@RunWith(Parameterized.class)
public class BaseClass 
{
	//thush
	public String browser;
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	//@SuppressWarnings("deprecation")
	//@Parameterized.Parameters("browser")
	
	//thush
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"chrome"}
            // Add other browsers here if needed
        });
    }
    
    //thush
    public BaseClass(String browser) {
        this.browser = browser;
    }
    
	
	@Before
	public void setup() {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		//DOMConfigurator.configure("log4j.xml");

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.edge.driver", readconfig.getIEPath());
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
        driver.manage().window().maximize();
    }
	
	/*
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		//DOMConfigurator.configure("log4j.xml");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	*/
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
//-------------------------------common methods---------------------------------------------------------------------------------
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{ 
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File source = ts.getScreenshotAs(OutputType.FILE); 
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target); 
		System.out.println("Screenshot taken"); 
	}
	
	
	//Use inside a test case, so we can use this as common method if other test cases also need this
	public String randomestring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	
	public String randomeNum()
	{
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
		 
			
}
