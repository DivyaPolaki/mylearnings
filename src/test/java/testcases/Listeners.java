package testcases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import resources.Extent;
import resources.base;


public class Listeners extends base implements ITestListener{
	ExtentTest test;
	ExtentReports extent;
	ThreadLocal<ExtentTest> threadtest;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		threadtest=new ThreadLocal<ExtentTest>();
		extent=Extent.getReportObject();
		test=extent.createTest(result.getMethod().getMethodName());
		threadtest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		threadtest.get().log(Status.PASS, "Test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriver driver=null;
		String testMethod=result.getMethod().getMethodName();
		threadtest.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			threadtest.get().addScreenCaptureFromPath(getScreenshot(testMethod,driver), testMethod)
			;}
			
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}