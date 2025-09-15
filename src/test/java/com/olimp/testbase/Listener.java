package com.olimp.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.olimp.utils.CommonMethods;




public class Listener implements ITestListener{

	
	public void onStart(ITestContext context)
	{
		System.out.println("Functionality test started!");
	}
	
	public void onFinish (ITestContext context)
	{
		System.out.println("Functionality test finished!");
	}
	
	public void onTestStart(ITestResult result)
	{
		// print the logs to the console
		System.out.println("Test will start: " + result.getName());
		
		//we want to create a test report,so the logs show in Extent report
		BaseClass.test = BaseClass.report.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		// print the logs to the console
		System.out.println("Test passed: "  + result.getName());
		
		//print test passed on the report
		BaseClass.test.pass("Test passed: " + result.getName());
		
		//take a screenshot and add it to the report
		String successImage = CommonMethods.takeScreenshot("passed/" + result.getName());
		BaseClass.test.addScreenCaptureFromPath(successImage);
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test failed: " + result.getName());
		
		//print test failed on the report
		BaseClass.test.fail("Test failed: " + result.getName());
		
		//take a screenshot and add it to the report
		String failImage = CommonMethods.takeScreenshot("failed/" + result.getName());
		BaseClass.test.addScreenCaptureFromPath(failImage);
	}
	
	
	
	
}
