package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGit {
	WebDriver driver;

	@Test
	public void launchBRowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt")).click();
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		//driver.switchTo().parentFrame();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Composite")).click();
		//driver.findElement(By.xpath("/html/body/div/ul[1]/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/ul[1]/li[5]/a")).click();
			
		Thread.sleep(2000);
		//driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		Thread.sleep(2000);
		//driver.findElement(By.linkText("ButtonModel")).click();
		//driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li/dl[1]/dd/a")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/ul/li/dl[1]/dd/a")).click();
}
}
}
