package com.HRM.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 

{
	public WebDriver driver;
	ReadConfig pro = new ReadConfig();
	public String url = pro.getApplicationURL();
	public String userName = pro.getUserName();
	public String passWord = pro.getPassWord();
	public Logger log;
	static String timeStamp;
	static String screenShotName;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		try {			
			if(br.equalsIgnoreCase("chrome"))
			{
				log = LogManager.getLogger();
				reporterOnStart(); // starting the reporter
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
				driver.manage().window().maximize();
				driver.get(url);
				log.info("Browser lauched successfully");
			}
			else if(br.equalsIgnoreCase("fireFox"))
			{
				log = LogManager.getLogger();
				reporterOnStart(); // starting the reporter
				//System.setProperty("webdriver.gecko.driver",pro.getFireFoxDriverPath());
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(url);
				log.info("Browser lauched successfully");
			}
	
		} catch (Exception e) {
			log.error("Failed to lauch the Browser "+e);
		}	
	}
	
	@AfterClass
	public void tearDown()
	{
		try {		
			driver.quit();
			extent.flush();
			log.info("Browser closed Successfully");
			log.info("****End of Test Case****");
		} catch (Exception e) {

			log.error("Failed to close the Browser "+e);
		}
		
	}
	
	
	public void reporterOnStart()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Custom-Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/extentReports/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","ADMIN");
		
		htmlReporter.config().setDocumentTitle("Orange HRM User Test Project"); // Tile of report
		htmlReporter.config().setReportName("Deatiled Test Summary Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);	
	}
	
	public void setLogger(String testName)
	{
		logger= extent.createTest(testName);
	}
	
	public void customLogger(Status status,String message,ExtentColor color)
	{	
		logger.log(status,MarkupHelper.createLabel(message,color));
	}
	
	public void onFailure(String name,WebDriver driver)
	{
		try {
			takeScreenshot(name, driver);
			String screenshotPath="H:\\HybridFrameWork\\OrangeHRM_Version_1.0\\ScreenShots\\"+name+".png";			
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		 catch (Exception e) 
		{
			System.out.println("Unable to locate the file "+e);
		}
		}	
	
	public void takeScreenshot(String name,WebDriver driver)
	{	
		try {
			timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			screenShotName=name+"-"+timeStamp;
			File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(".\\ScreenShots\\"+screenShotName+".png");
			FileHandler.copy(src,dest);
		} catch (Exception e) 
		{
			System.out.println("Unable to capture the screenShot"+e);
		}
		
		
	}

}
