package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EcommerceFormPage {
	
	public EcommerceFormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement Name;
	@AndroidFindBy(id="android:id/text1")
	public WebElement Dropdown;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement LetsShopButton;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement GoToCart;
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement CartTotalAmountText;
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> PopupOKButton;
	
}
