package MobileAutomation.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	AndroidDriver<AndroidElement> driver;

	public Utilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void scrollToElement(String textToScroll) {
		 driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + textToScroll + "\"));").click();
	}
}