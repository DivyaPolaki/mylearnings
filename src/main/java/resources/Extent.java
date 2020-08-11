package resources;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ReportAggregates;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Device;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Extent {
	static ExtentReports extent;
	public static ExtentReports getReportObject(){
		String reportpath=System.getProperty("user.dir")+"\\reports\\index.html";
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportpath);
		reporter.config().setDocumentTitle("Automation test report");
		reporter.config().setReportName("Web Automation test");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Divya Polaki");
		return extent;
	}
}