package Extentreport;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listener implements ITestListener {
	
	public ExtentReports extent;
	public ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getMethod().getMethodName(),"Test Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, result.getMethod().getMethodName(),"Test Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getMethod().getMethodName(),"Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		LogStatus status=test.getRunStatus();
		test.log(LogStatus.WARNING, result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Formcreatorfield.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
