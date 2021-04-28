package pageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EcommerceCheckoutPage {
	
	public EcommerceCheckoutPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<AndroidElement> ProductNames;
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<AndroidElement> AddToCarts;
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<AndroidElement> ProductPrices;
	
	
}
