package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import MobileAutomation.AppiumFramework.BaseClass;

public class Listeners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getName();
		System.out.println(testName);
		try {
			BaseClass.getScreenshot(testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
