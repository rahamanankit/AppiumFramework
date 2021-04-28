package MobileAutomation.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.EcommerceFormPage;

public class Ecommerce_TC extends BaseClass {
	@Test
	public void VerifyCartTotal() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		startAppiumServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		EcommerceFormPage p = new EcommerceFormPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Enter the Name in the field
		p.Name.sendKeys("Ankit");
		driver.hideKeyboard();
		// Select Gender as Female
		selectGender(driver, "Male");
		// Click on Dropdown and then scroll to select the value
		p.Dropdown.click();
		// Select Argentina from the dropdown
		selectCountry(driver, "Argentina");
		// Click on "Let's Shop" Button
		p.LetsShopButton.click();
		double priceOfFirstItem = scrollToProductAddToCartReturnCost(driver, "Jordan Lift Off");
		double priceOfSecondItem = scrollToProductAddToCartReturnCost(driver, "Jordan 6 Rings");
		// Click on "Go To Cart" Icon
		p.GoToCart.click();
		// Get the Total Amount of Cart (replace the $ sign)
		double actualTotalAmount = Double.parseDouble(p.CartTotalAmountText.getText().replace("$", ""));
		// Calculate the total of the items
		double expectedTotalAmount = priceOfFirstItem + priceOfSecondItem;
		Assert.assertEquals(expectedTotalAmount, actualTotalAmount);

	}

}
