package MobileAutomation.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.ApiDemosHomePage;

public class ApiDemosTC extends BaseClass {
	public static AppiumDriverLocalService service;

	@Test
	public void WifiSettingsTest() throws IOException {
		// TODO Auto-generated method stub
		// Using the Base class method to initialize the driver

		service = startAppiumServer();
		AndroidDriver<AndroidElement> driver = Capabilities("ApiDemosApp");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create object of the PageObject Class
		ApiDemosHomePage h = new ApiDemosHomePage(driver);
		h.Preferences.click();
		h.Pref_Dependencies.click();
		// Click on Wifi Checkbox
		h.WifiCheckbox.click();
		// Click on Wifi Settings using 2nd index
		h.WifiSettings.click();
		// Type text in the popup
		h.PopupTextBox.sendKeys("hello");
		// Click on OK button
		h.PopupOKButton.get(1).click();
		service.stop();

	}
	
	@Test(dataProvider="popupText", dataProviderClass=TestData.class)
	public void WifiSettingsTest(String text) throws IOException {
		// TODO Auto-generated method stub
		// Using the Base class method to initialize the driver

		service = startAppiumServer();
		AndroidDriver<AndroidElement> driver = Capabilities("ApiDemosApp");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create object of the PageObject Class
		ApiDemosHomePage h = new ApiDemosHomePage(driver);
		h.Preferences.click();
		h.Pref_Dependencies.click();
		// Click on Wifi Checkbox
		h.WifiCheckbox.click();
		// Click on Wifi Settings using 2nd index
		h.WifiSettings.click();
		// Type text in the popup
		h.PopupTextBox.sendKeys(text);
		// Click on OK button
		h.PopupOKButton.get(1).click();
		service.stop();

	}
	
	@BeforeTest
	public void killAllProcesses() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
}
