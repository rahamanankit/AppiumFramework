package MobileAutomation.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "popupText")
	public Object[][] getData() {
		Object[][] data = new Object[][] { { "hello" }, { "@#@SD" } };
		return data;
	}
}
