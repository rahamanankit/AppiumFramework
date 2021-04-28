package MobileAutomation.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.EcommerceCheckoutPage;

public class BaseClass {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException {
		Properties prop = new Properties();
		String projectPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(
				projectPath + "\\src\\main\\java\\MobileAutomation\\AppiumFramework\\global.properties");
		prop.load(fis);
		File f = new File("src");
		File fs = new File(f, prop.getProperty(appName));
		DesiredCapabilities caps = new DesiredCapabilities();
		String device = System.getProperty("device");
		if (device.contains("emulator")) {
			startEmulator();
		}
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		caps.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		return driver;
	}

	public static void selectCountry(AndroidDriver<AndroidElement> driver, String country) {
		Utilities u = new Utilities(driver);
		u.scrollToElement(country);
	}

	public static void selectGender(AndroidDriver<AndroidElement> driver, String gender) {
		driver.findElementByXPath("//android.widget.RadioButton[@text='" + gender + "']").click();
	}

	public static double scrollToProductAddToCartReturnCost(AndroidDriver<AndroidElement> driver, String productName) {
		EcommerceCheckoutPage c = new EcommerceCheckoutPage(driver);
		String productPrice = null;
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""
						+ productName + "\").instance(0))"));
		List<AndroidElement> productNames = c.ProductNames;
		List<AndroidElement> addToCarts = c.AddToCarts;
		List<AndroidElement> productPrices = c.ProductPrices;
		for (int i = 0; i < productNames.size(); i++) {
			if (productNames.get(i).getText().equalsIgnoreCase(productName)) {
				productPrice = productPrices.get(i).getText();
				// Click on the Add to Cart Button
				addToCarts.get(i).click();
				break;
			}
		}
		return Double.parseDouble(productPrice.replace("$", ""));
	}

	public AppiumDriverLocalService startAppiumServer() {
		boolean flag = checkIfServerRunning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator() throws IOException {
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
	}

	public static void getScreenshot(String fileName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\" + fileName + ".png");
		FileUtils.copyFile(src, dest);
	}
}
