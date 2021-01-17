package Assignment;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentTwo {

	WebDriver driver;

	@Before
	public void launchBRowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void logintest() throws InterruptedException {

		WebElement USERNAME_BUTTOM = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement PASSWORD_BUTTOM = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement LOGIN_BUTTOM = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		//Assert.assertEquals("Login page not found!!", "Login - iBilling", driver.getTitle());
		
		USERNAME_BUTTOM.sendKeys("demo@techfios.com");
		PASSWORD_BUTTOM.sendKeys("abc123");
		LOGIN_BUTTOM.click();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();

		WebElement CUSTOMER_BUTTON = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a"));
		WebElement ADD_CUSTOMER_BUTTON = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
		WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));
		
		Assert.assertEquals("Dashboard page not found!!", "Dashboard", DASHBOARD_ELEMENT.getText());
		
		CUSTOMER_BUTTON.click();

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(ADD_CUSTOMER_BUTTON));
		ADD_CUSTOMER_BUTTON.click();
		//Thread.sleep(2000);
		WebElement FULLNAME_BUTTON = driver.findElement(By.xpath("//input[@id='account']"));
		wait.until(ExpectedConditions.visibilityOf(FULLNAME_BUTTON));
		FULLNAME_BUTTON.sendKeys("Ujjwal Shreshta");
		
		WebElement DROP_DOWN_BUTTOM = driver.findElement(By.xpath("//*[@id=\"cid\"]"));
		Select sel = new Select(DROP_DOWN_BUTTOM);
		DROP_DOWN_BUTTOM.click();
		
		Thread.sleep(3000);
		DROP_DOWN_BUTTOM.sendKeys("Personal Company");
		
		//List<WebElement> options = sel.getOptions();
		//for (WebElement i: options) {
		//System.out.println(i.getText());
		
		//sel.selectByVisibleText("Personal Company");
		
		WebElement EMAIL_BUTTON = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		WebElement PHONE_BUTTON = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
		WebElement ADDRESS_BUTTON = driver.findElement(By.xpath("//input[@id=\"address\"]"));
		WebElement CITY_BUTTON = driver.findElement(By.xpath("//input[@id=\"city\"]"));
		WebElement STATE_BUTTON = driver.findElement(By.xpath("//input[@id=\"state\"]"));
		WebElement ZIP_CODE_BUTTON = driver.findElement(By.xpath("//input[@id=\"zip\"]"));
		//wait.until(ExpectedConditions.visibilityOf(EMAIL_BUTTON));
		EMAIL_BUTTON.sendKeys("ujjwal.shresthaaa@gmail.com");
		PHONE_BUTTON.sendKeys("9774481993");
		ADDRESS_BUTTON.sendKeys("2314, Northlake");
		CITY_BUTTON.sendKeys("Irving");
		STATE_BUTTON.sendKeys("Texas");
		ZIP_CODE_BUTTON.sendKeys("75038");
		
		JavascriptExecutor js=(JavascriptExecutor) driver; 
		js.executeScript("scroll(0,300)");
		
		Thread.sleep(2000);
		
		WebElement COUNTRY_BUTTON = driver.findElement(By.xpath("//select[@id=\"country\"]")); //Always Use Select xpath rather than others otherwise it won't work.
		Select sel1 = new Select(COUNTRY_BUTTON);
		sel1.selectByVisibleText("United States");

		Thread.sleep(2000);		
		WebElement CURRENCY_BUTTON = driver.findElement(By.xpath("//select[@id=\"currency\"]"));
		Select sel2 = new Select (CURRENCY_BUTTON);
		sel2.selectByVisibleText("USD");

		Thread.sleep(2000);
		WebElement GROUP_BUTTON = driver.findElement(By.xpath("//select[@id=\"group\"]"));
		Select sel3 = new Select (GROUP_BUTTON);
		sel3.selectByVisibleText("AUG 2020");

		Thread.sleep(2000);
		WebElement PASSWORD_BUTTON = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		WebElement  CONFIRM_PASSWORD_BUTTON = driver.findElement(By.xpath("//input[@id=\"cpassword\"]"));
		WebElement SAVE_BUTTON = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
		 PASSWORD_BUTTON.sendKeys("hello123");
		 CONFIRM_PASSWORD_BUTTON.sendKeys("hello123");
		 SAVE_BUTTON.click();

		Thread.sleep(2000);
		 Actions action1 = new Actions(driver);
		 action1.sendKeys(Keys.ENTER).build().perform();
		 		 
		 Thread.sleep(2000);
		 WebElement LIST_CUSTOMER_BUTTOM = driver.findElement(By.linkText("List Customers"));
		 LIST_CUSTOMER_BUTTOM.click();
		 
		 Thread.sleep(2000);
		 WebElement SEARCH_BUTTOM = driver.findElement(By.xpath("//input[@id=\"foo_filter\"]"));
		 SEARCH_BUTTOM.click();
		 SEARCH_BUTTOM.sendKeys("Ujjwal Shrestha");
		 
		 WebElement CONTACT_HEAD_BUTTON = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		 Assert.assertEquals("Contact page not found!!", "Contacts", CONTACT_HEAD_BUTTON.getText());
		 Thread.sleep(3000);
	}
		 @After
			public void tearDown() {
			driver.close();
}
}
