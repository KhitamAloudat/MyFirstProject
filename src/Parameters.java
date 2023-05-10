import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {
	static {
		WebDriverManager.edgedriver().setup();

	}
	WebDriver driver = new EdgeDriver();
	SoftAssert myAssertion = new SoftAssert();

	@BeforeTest
	public void mysetup() {
		driver.get("https://magento.softwaretestingboard.com/");
//		driver.manage().window().maximize();

	}
}
