import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Shopping extends Parameters {

	@Test()
	public void signUp() {
		driver.get("https://magento.softwaretestingboard.com/");

		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a")).click();
		driver.findElement(By.id("firstname")).sendKeys("Khitam" + Keys.TAB);
		driver.findElement(By.id("lastname")).sendKeys("Aloudat" + Keys.TAB);
		driver.findElement(By.id("is_subscribed")).click();
		driver.findElement(By.id("email_address")).sendKeys("kaloudat1998@gmail.com" + Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("3121992Aa@" + Keys.TAB);
		driver.findElement(By.id("password-confirmation")).sendKeys("3121992Aa@" + Keys.TAB);
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
		String expectedResult = "My Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
		String actualResult = driver.getTitle();
		myAssertion.assertEquals(actualResult, expectedResult);
		myAssertion.assertAll();
	}

	//----------------------------------------------------------------------------------------------------------------->
	
	
	@Test(invocationCount = 5)
	public void RandomSearch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String[] gender = { "Women", "Men" };
		String[] men = { "Jacket", "T-shirt", "Jeans", "Pants" };
		String[] women = { "Pants", "Jeans" };

		Random rand = new Random();

		int randomGender = rand.nextInt(2);
		int randomMen = rand.nextInt(4);
		int randomWomen = rand.nextInt(2);
		if (randomGender == 0) {
			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(women[randomWomen]+ Keys.ARROW_DOWN );
			System.out.println(women[randomWomen]);

			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys( Keys.ENTER );
			driver.findElement(By.xpath("//*[@id=\"search\"]")).clear();

		} else {
			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(men[randomMen]+ Keys.ARROW_DOWN + Keys.ARROW_DOWN );
			System.out.println(men[randomMen]);
			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys( Keys.ARROW_DOWN  );
			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys( Keys.ARROW_DOWN  );

			driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys( Keys.ENTER );
			driver.findElement(By.xpath("//*[@id=\"search\"]")).clear();

		}

	}
	
	//----------------------------------------------------------------------------------------------------------------->


	@Test(priority = 1)
	public void AddToCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		Random rand = new Random();
		int randomColor = rand.nextInt(3);
		int randomSize = rand.nextInt(4);

		for (int i = 0; i < 5; i++) {
			driver.get("https://magento.softwaretestingboard.com/");

			if (i == 0) { // radiantTee

				driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]"))
						.click();

				WebElement divContainSize = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> itemSize = divContainSize.findElements(By.tagName("div"));
				if (itemSize.size() > 0) {

					itemSize.get(randomSize).click();
				}
				WebElement divContainColor = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> itemColor = divContainColor.findElements(By.tagName("div"));
				if (itemColor.size() > 0) {

					itemColor.get(randomColor).click();
				}
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("3");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(10000);

			}
			if (i == 1) { // Breathe-Easy Tank

				driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]"))
						.click();

				WebElement divContainSize = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> itemSize = divContainSize.findElements(By.tagName("div"));
				if (itemSize.size() > 0) {

					itemSize.get(randomSize).click();
				}
				WebElement divContainColor = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> itemColor = divContainColor.findElements(By.tagName("div"));
				if (itemColor.size() > 0) {

					itemColor.get(randomColor).click();
				}
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("2");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(10000);

			}
			if (i == 2) { // Argus All-Weather Tank

				driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]"))
						.click();

				WebElement divContainSize = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> itemSize = divContainSize.findElements(By.tagName("div"));
				itemSize.get(randomSize).click();

				WebElement divContainColor = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> itemColor = divContainColor.findElements(By.tagName("div"));
				itemColor.get(randomColor).click();

				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("4");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(10000);

			}
			if (i == 3) { // Hero Hoodie

				driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]")).click();

				WebElement divContainSize = driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> itemSize = divContainSize.findElements(By.tagName("div"));
				if (itemSize.size() > 0) {
					itemSize.get(randomSize).click();
				}
				WebElement divContainColor = driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> itemColor = divContainColor.findElements(By.tagName("div"));
				if (itemColor.size() > 0) {
					itemColor.get(randomColor).click();
				}
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("1");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(10000);

			}

		}
		
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("5");
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		Thread.sleep(10000);

	}
	
	//----------------------------------------------------------------------------------------------------------------->

	@Test(priority = 2)
	public void cheackOut() throws InterruptedException {

		driver.findElement(By.className("showcart")).click();
		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
		Thread.sleep(8000);

		driver.findElement(By.id("customer-email")).sendKeys("Khetamaloudat1998@gmail.com");
		driver.findElement(By.name("firstname")).sendKeys("Khitam");
		driver.findElement(By.name("lastname")).sendKeys("Aloudat");
		driver.findElement(By.name("street[0]")).sendKeys("Bani-Kenanah");
		driver.findElement(By.name("street[1]")).sendKeys("Hatim");
		driver.findElement(By.name("street[2]")).sendKeys("Alzahraa street");
		driver.findElement(By.name("city")).sendKeys("Irbid");
		Select drpState = new Select(driver.findElement(By.name("region_id")));
		drpState.selectByVisibleText("Colorado");
		driver.findElement(By.name("postcode")).sendKeys("0987");
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("Jordan");
		driver.findElement(By.name("telephone")).sendKeys("0775281480");
		driver.findElement(By.name("ko_unique_1")).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(10000);

		
		Thread.sleep(10000);
//		driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
		
		
		String price = "$467.00";
		
		
		try {
			String totalOrder = price.replaceAll("[$]", "");
			
			double totalPrice = Double.parseDouble(totalOrder);
			
		
			Thread.sleep(5000);
		
		driver.findElement(By.xpath("//td[@data-th='Order Total']//strong//span"));
		
		Thread.sleep(5000);
		
		String actualPrice = driver.findElement(By.xpath("//td[@data-th='Order Total']//strong//span")).getText();
		System.out.println(actualPrice);

		String aPrice = actualPrice.replaceAll("[$]", "");
		
		double actPrice = Double.parseDouble(aPrice);
		System.out.println(actPrice);
		System.out.println("hi");
		myAssertion.assertEquals(totalPrice, actPrice);
		myAssertion.assertAll();
		Thread.sleep(5000);

		}catch(NumberFormatException ex) {
			System.out.println("hello");
			 ex.printStackTrace();
		}
		driver.findElement(By.className("checkout")).click();

	}

	//----------------------------------------------------------------------------------------------------------------->

	
	@Test(priority = 3)
	public void signIn() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("khetamaloudat1998@gmail.com" + Keys.TAB);
		driver.findElement(By.id("pass")).sendKeys("3121992Aa@");
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")).click();
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[2]/td[6]/a[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
			driver.findElement(	By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"))
					.click();

		}
	}
	
	//----------------------------------------------------------------------------------------------------------------->

	@Test(priority = 4)
	public void myOrder() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[2]/td[6]/a[1]")).click();

		// ===========================================================================================================

		String radiantPrice = "$198.00";

		try {
			String totalOrder = radiantPrice.replaceAll("[$]", "");
			double totalPrice = Double.parseDouble(totalOrder);
			// int expPrice = Integer.valueOf(price);
			// System.out.println(expPrice);
			Thread.sleep(5000);

			String actualPrice = driver.findElement(By.xpath("//*[@id=\"order-item-row-7507\"]/td[5]/span/span/span"))
					.getText();
			System.out.println(actualPrice);
			String aPrice = actualPrice.replaceAll("[$]", "");

			double actPrice = Double.parseDouble(aPrice);
			System.out.println(actPrice + "hi");

			myAssertion.assertEquals(totalPrice, actPrice);
			myAssertion.assertAll();

			Thread.sleep(5000);

		} catch (NumberFormatException ex) {
			System.out.println("hello");
			ex.printStackTrace();
		}

		// ===========================================================================================================

		String breatheEasytPrice = "$136.00";

		try {
			String totalbreatheEasytPrice = breatheEasytPrice.replaceAll("[$]", "");

			double totalPrice = Double.parseDouble(totalbreatheEasytPrice);

			// int expPrice = Integer.valueOf(price);
			// System.out.println(expPrice);
			Thread.sleep(5000);

			Thread.sleep(5000);

			String actualPricebreatheEasyt = driver
					.findElement(By.xpath("//*[@id=\"order-item-row-7509\"]/td[5]/span/span/span")).getText();
			System.out.println(actualPricebreatheEasyt);

			String apPrice = actualPricebreatheEasyt.replaceAll("[$]", "");

			double acttPrice = Double.parseDouble(apPrice);
			System.out.println(acttPrice);
			System.out.println("hi");
			myAssertion.assertEquals(totalPrice, acttPrice);
			myAssertion.assertAll();
			Thread.sleep(5000);

		} catch (NumberFormatException ex) {
			System.out.println("hello");
			ex.printStackTrace();
		}

		// ===========================================================================================================
		String RadiantXLPrice = "$132.00";

		try {
			String totalRadiantXLPrice = breatheEasytPrice.replaceAll("[$]", "");

			double totallPrice = Double.parseDouble(totalRadiantXLPrice);

			// int expPrice = Integer.valueOf(price);
			// System.out.println(expPrice);
			Thread.sleep(5000);


			Thread.sleep(5000);

			String actualtotalRadiantXLPrice = driver
					.findElement(By.xpath("//*[@id=\"order-item-row-7511\"]/td[5]/span/span/span")).getText();
			System.out.println(actualtotalRadiantXLPrice);

			String apPrice = actualtotalRadiantXLPrice.replaceAll("[$]", "");

			double acttualPrice = Double.parseDouble(apPrice);
			System.out.println(acttualPrice);
			System.out.println("hi");
			myAssertion.assertEquals(totallPrice, acttualPrice);
			myAssertion.assertAll();
			Thread.sleep(5000);

		} catch (NumberFormatException ex) {
			System.out.println("hello");
			ex.printStackTrace();
		}
		
		// ===========================================================================================================
		String breatheEasyXLPrice = "$136.00";

		try {
			String totalbreatheEasyXLPrice = breatheEasyXLPrice.replaceAll("[$]", "");

			double totallPriceebreatheEasyXL = Double.parseDouble(totalbreatheEasyXLPrice);

			
			Thread.sleep(5000);

			String actualbreatheEasyXLPrice = driver.findElement(By.xpath("//*[@id=\"order-item-row-7513\"]/td[5]/span")).getText();
			System.out.println(actualbreatheEasyXLPrice);

			String apPricee = actualbreatheEasyXLPrice.replaceAll("[$]", "");

			double actualbreatheEasyXLPricee = Double.parseDouble(apPricee);
			System.out.println(actualbreatheEasyXLPricee);
			System.out.println("hi");
			myAssertion.assertEquals(totallPriceebreatheEasyXL, actualbreatheEasyXLPricee);
			myAssertion.assertAll();
			Thread.sleep(5000);

		} catch (NumberFormatException ex) {
			System.out.println("hello");
			ex.printStackTrace();
		}

		// ===========================================================================================================
		String RadiantMPrice = "$132.00";

		try {
			String totalRadiantMPricePrice = RadiantMPrice.replaceAll("[$]", "");

			double totallPriceRadiantM = Double.parseDouble(totalRadiantMPricePrice);

			Thread.sleep(5000);

			String actualtotalRadiantMPricePrice = driver.findElement(By.xpath("//*[@id=\"order-item-row-7515\"]/td[5]/span/span/span")).getText();
			System.out.println(actualtotalRadiantMPricePrice);

			String apPricee = actualtotalRadiantMPricePrice.replaceAll("[$]", "");

			double actualRadiantMPricePrice = Double.parseDouble(apPricee);
			System.out.println(actualRadiantMPricePrice);
			System.out.println("hi");
			myAssertion.assertEquals(totallPriceRadiantM, actualRadiantMPricePrice);
			myAssertion.assertAll();
			Thread.sleep(5000);

		} catch (NumberFormatException ex) {
			System.out.println("hello");
			ex.printStackTrace();
		}

	}
}
