package steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload {
	public static WebDriver driver;
@Test
	
	public void login() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();;
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       Thread.sleep(3000);
       driver.get("https://smallpdf.com/pdf-to-word");
       Thread.sleep(4000);
      // driver.findElement(By.xpath("//input[@id='__picker-input']")).sendKeys("C:\\Users\\Anyone\\Documents\\test.pdf");
       driver.findElement(By.xpath("//input[@id='__picker-input']")).click();
       Thread.sleep(2000);
       Runtime.getRuntime().exec(System.getProperty("user.dir") + "//utilities//upload1.exe");


}
}
