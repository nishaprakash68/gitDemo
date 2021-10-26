package steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Form {
	
	public static WebDriver driver;
	@Test
		
		public void login() throws InterruptedException, IOException
		{
			WebDriverManager.chromedriver().setup();;
	       driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       Thread.sleep(3000);
	       driver.get("https://www.pulsetechsolutions.com.au/contact/");
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//input[@name='YourName']")).click();
	       driver.findElement(By.xpath("//input[@name='YourName']")).sendKeys("John Doe");
	       System.out.println("demo123");
	       
	       
	     


	}
	}



