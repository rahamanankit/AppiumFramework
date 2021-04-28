package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemosHomePage {
	
	public ApiDemosHomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement Pref_Dependencies;
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement WifiCheckbox;
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement WifiSettings;
	@AndroidFindBy(className="android.widget.EditText")
	public WebElement PopupTextBox;
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> PopupOKButton;
	
}
