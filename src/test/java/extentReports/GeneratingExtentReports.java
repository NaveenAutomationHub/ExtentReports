package extentReports;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GeneratingExtentReports {
	
@Test
	public void LoginTest() throws IOException{
		
		ExtentHtmlReporter report = new ExtentHtmlReporter("./Reports/naveen_report.html");
		ExtentReports eReport = new ExtentReports();
		eReport.attachReporter(report);
		ExtentTest eTest = eReport.createTest("LoginTest");
		eTest.log(Status.INFO, "Test Started here");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys("naveendommata");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[2]")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		driver.manage().window().maximize();
		eTest.log(Status.INFO, "Successfully logged into FreeCRM");
		eTest.addScreenCaptureFromPath("screenshot.png");
		
		eReport.flush();
	}
	
	@Test
	public void Titletest() throws IOException{
		
		ExtentHtmlReporter report = new ExtentHtmlReporter("./Reports/naveen_report.html");
		ExtentReports eReport = new ExtentReports();
		eReport.attachReporter(report);
		ExtentTest eTest = eReport.createTest("LoginTest");
		eTest.log(Status.INFO, "Test Started here");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[1]")).sendKeys("naveendommata");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/input[2]")).sendKeys("Welcome@123");
		driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		driver.manage().window().maximize();
		eTest.log(Status.INFO, "Successfully logged into FreeCRM");
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "CRMPR");
		
		eTest.log(Status.FAIL, "Failed to validate title");
		eTest.fail("Failed test", MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/screenshot.png").build());
		eReport.flush();
	}

}
